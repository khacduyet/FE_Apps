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
public class ExamStudent {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";
    JWT _jwt = new JWT();

    @RequestMapping(value = "/examstudent", method = RequestMethod.GET)
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

        String Url = baseUrl + "contest/contest_user/" + cu.getId();
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<Contest> contest = (List<Contest>) c.data;
        m.addAttribute("contest", contest);

        String msg = (String) m.asMap().get("msg");
        m.addAttribute("msg", msg);
        m.addAttribute("VIEW", "Views/ExamStudent/index.jsp");
        return "MainPages";
    }

    @RequestMapping(value = "/start_exam", method = RequestMethod.GET)
    public String getForm(Model m, HttpServletRequest req, String idContest) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", "text/plain; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "contest/get_exam/" + idContest;
        String UrlContest = baseUrl + "contest/" + idContest;
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responseContest = rt.exchange(UrlContest, HttpMethod.GET, entity, String.class);
        String data = response.getBody();
        String dataContest = responseContest.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        ReturnMessage cContest = g.fromJson(dataContest, ReturnMessage.class);
        String datacContest = g.toJson(cContest.data);
        List<Question> questions = (List<Question>) c.data;
        Contest contest = g.fromJson(datacContest, Contest.class);

        m.addAttribute("VIEW", "Views/ExamStudent/doExam.jsp");
        m.addAttribute("questions", questions);
        m.addAttribute("count", questions.size());
        m.addAttribute("contest", contest);
        return "MainPages";
    }

    @RequestMapping(value = "/finished_exam", method = RequestMethod.POST)
    public String postForm(Model m, int count, ResultExam re, HttpServletRequest req, RedirectAttributes redirectAttrs) {
//        String auth = CheckLogin(req);
//        if (auth.isEmpty()) {
//            return "redirect:/login.htm";
//        }
//        CurrentUser cu = _jwt.getUserFromToken(auth);
//
//        List<String> answers = new ArrayList<>();
//        for (int i = 1; i <= count; i++) {
//            String answer = req.getParameter("question" + i);
//            if (answer == null) {
//                answer = "";
//            }
//            answers.add(answer);
//        }
//        re.setIdAnswer(answers);
//        re.setIdUser(cu.getId());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("authorization", auth);
//        headers.set("Content-Type", "application/json; charset=UTF-8");
//        headers.set("Accept", "application/json");
//        Gson g = new Gson();
//        String e = g.toJson(re);
//        HttpEntity<String> entity = new HttpEntity<String>(e, headers);
//
//        String Url = baseUrl + "contest/finishedExam";
//        RestTemplate rt = new RestTemplate();
//        rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        String data = rt.postForObject(Url, entity, String.class);
//
//        ReturnMessage rmsg = g.fromJson(data, ReturnMessage.class);
//        String msg = rmsg.message;
//        String rdata = g.toJson(rmsg.data);
//        ReturnResult rr = g.fromJson(rdata, ReturnResult.class);
//        redirectAttrs.addFlashAttribute("msg", msg);
//        m.addAttribute("rr", rr);
        m.addAttribute("VIEW", "Views/ExamStudent/result.jsp");
        return "MainPages";
    }
}
