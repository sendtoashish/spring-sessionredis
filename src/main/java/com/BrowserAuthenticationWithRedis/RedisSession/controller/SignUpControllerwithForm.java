package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import com.BrowserAuthenticationWithRedis.RedisSession.Service.UserRegistrationService;
import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpControllerwithForm {

    @Autowired
    private UserRegistrationService userRegistrationService;


    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignUp(@RequestParam String username, @RequestParam String password, @RequestParam String email,HttpSession httpSession) {
        userRegistrationService.saveUser(username, password,email);
  //      UserEntity user = UserEntity.builder().username(username)
        //        .password(password)
         //       .email(email).build();
     //   httpSession.setAttribute("user",user);

        // Redirect to the login page after successful signup
        return "redirect:/login?signup";
    }
}
