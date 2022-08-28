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
import entities.Contest;
import entities.Question;
import entities.ResultExam;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import model.CurrentUser;
import model.JWT;
import java.nio.charset.StandardCharsets;
import model.ReturnResult;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author AdminDEV
 */
@Controller
public class HistoryController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
    JWT _jwt = new JWT();

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        CurrentUser cu = _jwt.getUserFromToken(auth);

        String Url = baseUrl + "contest/result_exam";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<ReturnResult> rr = (List<ReturnResult>) c.data;
        m.addAttribute("rr", rr);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/History/index.jsp");

        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/history/detail", method = RequestMethod.GET)
    public String getForm(Model m, HttpServletRequest req, @RequestParam(value = "id") String id, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        CurrentUser cu = _jwt.getUserFromToken(auth);

        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        headers.set("Accept", "application/json");
        Gson g = new Gson();
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest/result_exam/" + id;
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        String rdata = g.toJson(rmsg.data);
        ReturnResult rr = g.fromJson(rdata, ReturnResult.class);
        redirectAttrs.addFlashAttribute("msg", msg);
        m.addAttribute("rr", rr);
        m.addAttribute("VIEW", "Views/History/result.jsp");

        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }
}
