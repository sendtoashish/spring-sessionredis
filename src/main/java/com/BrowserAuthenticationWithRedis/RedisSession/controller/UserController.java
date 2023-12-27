package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import com.BrowserAuthenticationWithRedis.RedisSession.Service.UserService;
import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping(value="/saveuser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
      boolean result=  userservice.saveUser(user);
        if(result)
            return ResponseEntity.ok("User Saved successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
