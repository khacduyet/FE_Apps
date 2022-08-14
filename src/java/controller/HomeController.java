/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import static controller.CommonController.CheckLogin;
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
import entities.ReturnMessage;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index(Model m, HttpServletRequest req) {
        String auth = CheckLogin(req);
        if (auth.isEmpty()) {
            return "redirect:/login.htm";
        }
        m.addAttribute("VIEW", "Views/Home.jsp");
        return "MainPages";
    }

}
