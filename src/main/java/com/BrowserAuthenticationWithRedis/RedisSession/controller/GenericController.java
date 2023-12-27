package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class GenericController {


@GetMapping(value="/save")
    public String saveUsername(@RequestParam String firstname , @RequestParam String lastname, HttpSession httpSession){
    String userName = firstname +" " + lastname;
    httpSession.setAttribute("username",userName);
    return "user details save";
}

@GetMapping(value="/getsessionuser")
public String greetUser(HttpSession httpSession) {

    return "Hello, Mr." + httpSession.getAttribute("username");
}
}
