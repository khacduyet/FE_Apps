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
import entities.Exam;
import entities.Subject;
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
public class ContestController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
        JWT jwt = new JWT();


    @RequestMapping(value = "/contest", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<Contest> cla = (List<Contest>) c.data;
        m.addAttribute("data", cla);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/Contest/index.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/contest/initInsert", method = RequestMethod.GET)
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

        String UrlExam = baseUrl + "exam";
        String UrlClass = baseUrl + "class";
        String UrlSubject = baseUrl + "subject";

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> responseExam = rt.exchange(UrlExam, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseClass = rt.exchange(UrlClass, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        String dataExam = responseExam.getBody();
        String dataClass = responseClass.getBody();
        String dataSubject = responseSubject.getBody();

        Gson g = new Gson();
        ReturnMessage e = g.fromJson(dataExam, ReturnMessage.class);
        ReturnMessage clas = g.fromJson(dataClass, ReturnMessage.class);
        ReturnMessage subjects = g.fromJson(dataSubject, ReturnMessage.class);
        List<Exam> exam = (List<Exam>) e.data;
        List<entities.Class> cla = (List<entities.Class>) clas.data;
        List<Subject> subs = (List<Subject>) subjects.data;
        m.addAttribute("exam", exam);
        m.addAttribute("cla", cla);
        m.addAttribute("subs", subs);

        Contest contest = new Contest();
        m.addAttribute("c", contest);
        m.addAttribute("VIEW", "Views/Contest/add.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/contest/insert", method = RequestMethod.POST)
    public String postForm(Model m, Contest c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
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

        String Url = baseUrl + "contest";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/contest.htm";
    }

    @RequestMapping(value = "/contest/initEdit", method = RequestMethod.GET)
    public String getedForm(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest/" + id;
        String UrlExam = baseUrl + "exam";
        String UrlClass = baseUrl + "class";
        String UrlSubject = baseUrl + "subject";

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseExam = rt.exchange(UrlExam, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseClass = rt.exchange(UrlClass, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        String data = response.getBody();
        String dataExam = responseExam.getBody();
        String dataClass = responseClass.getBody();
        String dataSubject = responseSubject.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        ReturnMessage e = g.fromJson(dataExam, ReturnMessage.class);
        ReturnMessage clas = g.fromJson(dataClass, ReturnMessage.class);
        ReturnMessage subjects = g.fromJson(dataSubject, ReturnMessage.class);
        Contest contest = new Contest();
        String json = g.toJson(c.data);
        contest = g.fromJson(json, contest.getClass());
        List<Exam> exam = (List<Exam>) e.data;
        List<entities.Class> cla = (List<entities.Class>) clas.data;
        List<Subject> subs = (List<Subject>) subjects.data;
        m.addAttribute("c", contest);
        m.addAttribute("exam", exam);
        m.addAttribute("cla", cla);
        m.addAttribute("subs", subs);

        m.addAttribute("VIEW", "Views/Contest/edit.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }
    
    @RequestMapping(value = "/contest/detail", method = RequestMethod.GET)
    public String getedDetail(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest/" + id;
        String UrlExam = baseUrl + "exam";
        String UrlClass = baseUrl + "class";
        String UrlSubject = baseUrl + "subject";

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseExam = rt.exchange(UrlExam, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseClass = rt.exchange(UrlClass, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        String data = response.getBody();
        String dataExam = responseExam.getBody();
        String dataClass = responseClass.getBody();
        String dataSubject = responseSubject.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        ReturnMessage e = g.fromJson(dataExam, ReturnMessage.class);
        ReturnMessage clas = g.fromJson(dataClass, ReturnMessage.class);
        ReturnMessage subjects = g.fromJson(dataSubject, ReturnMessage.class);
        Contest contest = new Contest();
        String json = g.toJson(c.data);
        contest = g.fromJson(json, contest.getClass());
        List<Exam> exam = (List<Exam>) e.data;
        List<entities.Class> cla = (List<entities.Class>) clas.data;
        List<Subject> subs = (List<Subject>) subjects.data;
        m.addAttribute("c", contest);
        m.addAttribute("exam", exam);
        m.addAttribute("cla", cla);
        m.addAttribute("subs", subs);

        m.addAttribute("VIEW", "Views/Contest/detail.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }


    @RequestMapping(value = "/contest/edit", method = RequestMethod.POST)
    public String postedForm(Model m, Contest c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
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

        String Url = baseUrl + "contest";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/contest.htm";
    }

    @RequestMapping(value = "/contest/remove", method = RequestMethod.GET)
    public String remove(Model m, @RequestParam(value = "id") String id, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest/" + id;
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.DELETE, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        String msg = c.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/contest.htm";
    }
}
