/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import static controller.CommonController.CheckLogin;
import entities.ReturnMessage;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import entities.Class;
import entities.LevelPoint;
import java.nio.charset.StandardCharsets;
import model.CurrentUser;
import model.JWT;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class LevelPointController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
    JWT jwt = new JWT();

    @RequestMapping(value = "/level-point", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "level-point";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<LevelPoint> cla = (List<LevelPoint>) c.data;
        m.addAttribute("data", cla);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/LevelPoint/index.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/level-point/initInsert", method = RequestMethod.GET)
    public String getForm(Model m, HttpServletRequest req) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        LevelPoint cla = new LevelPoint();
        m.addAttribute("VIEW", "Views/LevelPoint/add.jsp");
        m.addAttribute("c", cla);
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/level-point/insert", method = RequestMethod.POST)
    public String postForm(Model m, LevelPoint c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Accept", "application/json");
        Gson g = new Gson();
        String e = g.toJson(c);
        HttpEntity<String> entity = new HttpEntity<String>(e, headers);

        String Url = baseUrl + "level-point";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/level-point.htm";
    }

    @RequestMapping(value = "/level-point/initEdit", method = RequestMethod.GET)
    public String getedForm(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "level-point/" + id;
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        String json = g.toJson(c.data);
        LevelPoint cla = new LevelPoint();
        cla = g.fromJson(json, cla.getClass());
        m.addAttribute("c", cla);
        m.addAttribute("VIEW", "Views/LevelPoint/edit.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/level-point/edit", method = RequestMethod.POST)
    public String postedForm(Model m, LevelPoint c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Accept", "application/json");
        Gson g = new Gson();
        String e = g.toJson(c);
        HttpEntity<String> entity = new HttpEntity<String>(e, headers);

        String Url = baseUrl + "level-point";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/level-point.htm";
    }

    @RequestMapping(value = "/level-point/remove", method = RequestMethod.GET)
    public String remove(Model m, @RequestParam(value = "id") String id, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "level-point/" + id;
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.DELETE, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        String msg = c.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/level-point.htm";
    }
}
