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
import entities.Exam;
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
public class ExamController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
    JWT jwt = new JWT();

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "exam";
        String UrlSubject = baseUrl + "subject";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        String data = response.getBody();
        String dataSubject = responseSubject.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        List<Exam> cla = (List<Exam>) c.data;
        List<Subject> subjects = (List<Subject>) sub.data;
        m.addAttribute("data", cla);
        m.addAttribute("subjects", subjects);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/Exam/index.jsp");
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/exam/initInsert", method = RequestMethod.GET)
    public String getForm(Model m, HttpServletRequest req, @RequestParam(value = "idSub") String idSub) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String UrlQuestion = baseUrl + "exam/subject/" + idSub;
        String UrlSubject = baseUrl + "subject/" + idSub;
        String UrlLevel = baseUrl + "level-point";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> responseQuestion = rt.exchange(UrlQuestion, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseLevel = rt.exchange(UrlLevel, HttpMethod.GET, entity, String.class);
        String dataQuestion = responseQuestion.getBody();
        String dataSubject = responseSubject.getBody();
        String dataLevel = responseLevel.getBody();

        Gson g = new Gson();
        ReturnMessage ques = g.fromJson(dataQuestion, ReturnMessage.class);
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        ReturnMessage level = g.fromJson(dataLevel, ReturnMessage.class);
        List<Question> questions = (List<Question>) ques.data;
        String subs = g.toJson(sub.data);
        Subject subject = g.fromJson(subs, Subject.class);
        List<LevelPoint> levels = (List<LevelPoint>) level.data;
        m.addAttribute("questions", questions);
        m.addAttribute("subject", subject);
        m.addAttribute("levels", levels);

        Exam cla = new Exam();
        m.addAttribute("VIEW", "Views/Exam/add.jsp");
        m.addAttribute("c", cla);
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/exam/insert", method = RequestMethod.POST)
    public String postForm(Model m, Exam c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
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

        String Url = baseUrl + "exam";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/exam.htm";
    }

    @RequestMapping(value = "/exam/initEdit", method = RequestMethod.GET)
    public String getedForm(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "exam/" + id;

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String dataQuestion = response.getBody();
        Gson g = new Gson();
        ReturnMessage c = g.fromJson(dataQuestion, ReturnMessage.class);
        String json = g.toJson(c.data);
        Exam exam = new Exam();
        exam = g.fromJson(json, exam.getClass());

        String UrlQuestion = baseUrl + "exam/subject/" + exam.getIdSubject();
        String UrlSubject = baseUrl + "subject/" + exam.getIdSubject();
        String UrlLevel = baseUrl + "level-point";

        ResponseEntity<String> responseQuestion = rt.exchange(UrlQuestion, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseLevel = rt.exchange(UrlLevel, HttpMethod.GET, entity, String.class);
        String dataQuestionSub = responseQuestion.getBody();
        String dataSubject = responseSubject.getBody();
        String dataLevel = responseLevel.getBody();

        ReturnMessage ques = g.fromJson(dataQuestionSub, ReturnMessage.class);
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        ReturnMessage level = g.fromJson(dataLevel, ReturnMessage.class);
        List<Question> questions = (List<Question>) ques.data;
        String subs = g.toJson(sub.data);
        Subject subject = g.fromJson(subs, Subject.class);
        List<LevelPoint> levels = (List<LevelPoint>) level.data;
        m.addAttribute("questions", questions);
        m.addAttribute("subject", subject);
        m.addAttribute("levels", levels);

        m.addAttribute("VIEW", "Views/Exam/edit.jsp");
        m.addAttribute("c", exam);
        
        CurrentUser cu = jwt.getUserFromToken(auth);
        m.addAttribute("currentUser", cu);
        m.addAttribute("role", cu.getRoles().get(0));
        return "MainPages";
    }

    @RequestMapping(value = "/exam/detais", method = RequestMethod.GET)
    public String getedDetail(Model m, @RequestParam(value = "id") String id, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "exam/" + id;

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String dataQuestion = response.getBody();
        Gson g = new Gson();
        ReturnMessage c = g.fromJson(dataQuestion, ReturnMessage.class);
        String json = g.toJson(c.data);
        Exam exam = new Exam();
        exam = g.fromJson(json, exam.getClass());

        String UrlQuestion = baseUrl + "exam/subject/" + exam.getIdSubject();
        String UrlSubject = baseUrl + "subject/" + exam.getIdSubject();
        String UrlLevel = baseUrl + "level-point";

        ResponseEntity<String> responseQuestion = rt.exchange(UrlQuestion, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseSubject = rt.exchange(UrlSubject, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseLevel = rt.exchange(UrlLevel, HttpMethod.GET, entity, String.class);
        String dataQuestionSub = responseQuestion.getBody();
        String dataSubject = responseSubject.getBody();
        String dataLevel = responseLevel.getBody();

        ReturnMessage ques = g.fromJson(dataQuestionSub, ReturnMessage.class);
        ReturnMessage sub = g.fromJson(dataSubject, ReturnMessage.class);
        ReturnMessage level = g.fromJson(dataLevel, ReturnMessage.class);
        List<Question> questions = (List<Question>) ques.data;
        String subs = g.toJson(sub.data);
        Subject subject = g.fromJson(subs, Subject.class);
        List<LevelPoint> levels = (List<LevelPoint>) level.data;
        m.addAttribute("questions", questions);
        m.addAttribute("subject", subject);
        m.addAttribute("levels", levels);

        m.addAttribute("VIEW", "Views/Exam/details.jsp");
        m.addAttribute("c", exam);
        return "MainPages";
    }

    @RequestMapping(value = "/exam/edit", method = RequestMethod.POST)
    public String postedForm(Model m, Exam c, HttpServletRequest req, RedirectAttributes redirectAttrs) {
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

        String Url = baseUrl + "exam";
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String data = rt.postForObject(Url, entity, String.class);

        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
        String msg = rmsg.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/exam.htm";
    }

    @RequestMapping(value = "/exam/remove", method = RequestMethod.GET)
    public String remove(Model m, @RequestParam(value = "id") String id, HttpServletRequest req, RedirectAttributes redirectAttrs) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "exam/" + id;
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.DELETE, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        String msg = c.message;
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/exam.htm";
    }
}
