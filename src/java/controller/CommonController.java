/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class CommonController {
    public static String CheckLogin(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String auth = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("authorization")) {
                    auth = cookie.getValue();
                }
            }
        }
        if (auth.isEmpty()) {
            return "redirect:login.htm";
        }
        return auth;
    }
}
