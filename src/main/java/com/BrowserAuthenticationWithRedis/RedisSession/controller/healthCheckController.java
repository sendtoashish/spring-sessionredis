package com.BrowserAuthenticationWithRedis.RedisSession.controller;

import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.actuate.health.Health;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping(value="/healthcheck")
public class healthCheckController {
    @Secured("ROLE_USER")
    @GetMapping("url_check")
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/redisuser")
    public UserEntity userFromRedis(HttpSession httpSession ){
        return  (UserEntity) httpSession.getAttribute("user");

}
}

