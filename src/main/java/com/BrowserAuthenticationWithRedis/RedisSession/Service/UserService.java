package com.BrowserAuthenticationWithRedis.RedisSession.Service;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean saveUser(User user){
        userDao.save(user);
        return true;
    }
}
