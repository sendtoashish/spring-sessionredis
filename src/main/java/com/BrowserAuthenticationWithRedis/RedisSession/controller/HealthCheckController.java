package com.BrowserAuthenticationWithRedis.RedisSession.controller;


import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping(value="/healthcheck")
public class HealthCheckController {

    @GetMapping
    public Health checkHealth() throws IOException {
        URL siteURL =new URL("https://www.google.com");
        HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        if (code == 200){
            return Health.up().build();
        }else{
            return Health.down().build();
        }
    }

}
