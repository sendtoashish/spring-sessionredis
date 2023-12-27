package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import com.BrowserAuthenticationWithRedis.RedisSession.Service.loginService;
import com.BrowserAuthenticationWithRedis.RedisSession.model.CredentialPayload;
import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/login")
public class loginController {

    @Autowired
    loginService loginService;
    @GetMapping(value="/redis")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password, HttpSession httpSession){
        User user = loginService.login(username,password);
        httpSession.setAttribute("user",user);
        return ResponseEntity.ok().body("Session saved in Redis");

    }
    @GetMapping(value="/valueFromRedis")
    public ResponseEntity<User> greetUser(HttpSession httpSession) {

        User userFromRedis= (User)httpSession.getAttribute("user");
        System.out.println(userFromRedis);
        User user = new User();
        user.setUserName(userFromRedis.getUserName());
        user.setEmail(userFromRedis.getEmail());
        return ResponseEntity.ok().body(user);


    }
}
