package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserEntityDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginControllerwithform {
    @Autowired
    UserEntityDao userEntityDao;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    }

