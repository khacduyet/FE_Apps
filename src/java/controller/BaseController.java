/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Users;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
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
public class BaseController {

    String baseUrl = "http://localhost:8080/ExamApplication/api/";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "Login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(Model m, Users user, HttpServletResponse res) {
        String Url = baseUrl + "login";
        RestTemplate rt = new RestTemplate();
        String response = rt.postForObject(Url, user, String.class);
        if (response.startsWith("ey")) {
            Cookie cookie = new Cookie("authorization", response);
            cookie.setMaxAge(3600);
            res.addCookie(cookie);
            return "redirect:home.htm";
        }
        m.addAttribute("error", response);
        m.addAttribute("user", user);
        return "Login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String viewLogout(HttpServletResponse res, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
        }
        return "redirect:login.htm";
    }
}
