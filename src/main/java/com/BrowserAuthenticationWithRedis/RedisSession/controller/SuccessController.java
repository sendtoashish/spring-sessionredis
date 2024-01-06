package com.BrowserAuthenticationWithRedis.RedisSession.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpRequest;
import java.util.Enumeration;

@Controller
public class SuccessController {

    @GetMapping("/success")
    public String success(HttpRequest request, HttpSession session) {

        Enumeration<String> attributes =  session.getAttributeNames();



        return "success"; // Thymeleaf template name (success.html)
    }
}
