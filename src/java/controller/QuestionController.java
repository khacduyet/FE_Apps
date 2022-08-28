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
import entities.Question;
import entities.QuestionItem;
import entities.Subject;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
public class QuestionController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
    JWT jwt = new JWT();

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "question";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<Question> cla = (List<Question>) c.data;
        m.addAttribute("data", cla);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/Question/index.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/question/initInsert", method = RequestMethod.GET)
    public String getForm(Model m, HttpServletRequest req) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String UrlSubject = baseUrl + "subject";
        String UrlLevel = baseUrl + "level-point";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseLevel = rt.exchange(UrlLevel, HttpMethod.GET, entity, String.class);
        String dataSubject = responseSubject.getBody();
        String dataLevel = responseLevel.getBody();

        Gson g = new Gson();
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        ReturnMessage level = g.fromJson(dataLevel, ReturnMessage.class);
        List<Subject> subjects = (List<Subject>) sub.data;
        List<LevelPoint> levels = (List<LevelPoint>) level.data;
        m.addAttribute("subjects", subjects);
        m.addAttribute("levels", levels);

        Question cla = new Question();
        m.addAttribute("VIEW", "Views/Question/add.jsp");
        m.addAttribute("c", cla);
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/question/insert", method = RequestMethod.POST)
    public String postForm(Model m, Question c, String[] answer, int[] isTrue, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Accept", "application/json");
        List<QuestionItem> qis = new ArrayList<>();
        int count = 0;
        for (String a : answer) {
            QuestionItem qi = new QuestionItem();
            qi.setNote(a);
            qi.setName(count + "");
            if (count == isTrue[0]) {
                qi.setIsTrue(Boolean.TRUE);
            } else {
                qi.setIsTrue(Boolean.FALSE);
            }
            qis.add(qi);
            count++;
        }
        c.setItems(qis);
        Gson g = new Gson();
        String e = g.toJson(c);
        HttpEntity<String> entity = new HttpEntity<String>(e, headers);

        String Url = baseUrl + "question";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/question.htm";
    }

    @RequestMapping(value = "/question/initEdit", method = RequestMethod.GET)
    public String getedForm(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "question/" + id;
        String UrlSubject = baseUrl + "subject";
        String UrlLevel = baseUrl + "level-point";

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseLevel = rt.exchange(UrlLevel, HttpMethod.GET, entity, String.class);
        String data = response.getBody();
        String dataSubject = responseSubject.getBody();
        String dataLevel = responseLevel.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        ReturnMessage level = g.fromJson(dataLevel, ReturnMessage.class);
        List<Subject> subjects = (List<Subject>) sub.data;
        List<LevelPoint> levels = (List<LevelPoint>) level.data;

        m.addAttribute("subjects", subjects);
        m.addAttribute("levels", levels);

        String json = g.toJson(c.data);
        Question cla = new Question();
        cla = g.fromJson(json, cla.getClass());

        QuestionItem pos0 = cla.Items.get(0);
        QuestionItem pos1 = cla.Items.get(1);
        QuestionItem pos2 = cla.Items.get(2);
        QuestionItem pos3 = cla.Items.get(3);

        m.addAttribute("VIEW", "Views/Question/edit.jsp");
        m.addAttribute("c", cla);
        m.addAttribute("pos0", pos0);
        m.addAttribute("pos1", pos1);
        m.addAttribute("pos2", pos2);
        m.addAttribute("pos3", pos3);
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/question/edit", method = RequestMethod.POST)
    public String postedForm(Model m, Question c, String[] answer, int[] isTrue, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Accept", "application/json");

        List<QuestionItem> qis = new ArrayList<>();
        int count = 0;
        for (String a : answer) {
            QuestionItem qi = new QuestionItem();
            qi.setNote(a);
            qi.setName(count + "");
            if (count == isTrue[0]) {
                qi.setIsTrue(Boolean.TRUE);
            } else {
                qi.setIsTrue(Boolean.FALSE);
            }
            qis.add(qi);
            count++;
        }
        c.setItems(qis);

        Gson g = new Gson();
        String e = g.toJson(c);
        HttpEntity<String> entity = new HttpEntity<String>(e, headers);

        String Url = baseUrl + "question";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/question.htm";
    }

    @RequestMapping(value = "/question/remove", method = RequestMethod.GET)
    public String remove(Model m, @RequestParam(value = "id") String id, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "question/" + id;
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.DELETE, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        String msg = c.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/question.htm";
    }
}
