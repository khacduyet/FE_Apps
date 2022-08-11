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
import javax.servlet.http.Cookie;
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

/**
 *
 * @author Admin
 */
@Controller
public class ClassController {
    String baseUrl = "http://localhost:8080/ExamApplication/api/";
    String contentType = "text/html; charset=UTF-8";

    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req) {
        String auth = CheckLogin(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", auth);
        headers.set("Content-Type", contentType);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String Url = baseUrl + "class";
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(Url, HttpMethod.GET, entity, String.class);
        String data = response.getBody();

        Gson g = new Gson();
        ReturnMessage c = g.fromJson(data, ReturnMessage.class);
        List<entities.Class> cla = (List<entities.Class>) c.data;
        m.addAttribute("data", cla);
        
        m.addAttribute("VIEW", "Views/Home.jsp");
        return "MainPages";
    }
}
