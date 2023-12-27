package com.BrowserAuthenticationWithRedis.RedisSession.Service;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.CredentialPayload;
import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
   @Autowired
    UserDao userdao;

    public User login(String username,String password){
       User userFromDb = userdao.findUserbyUsername(username);
       String passwordFromDb = userFromDb.getPassword();
       if(password.equals(passwordFromDb)){
           return userFromDb;
       }
       return null;
       }
    }

