package com.BrowserAuthenticationWithRedis.RedisSession.Service;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserEntityDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserEntityDao userEntityDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(String userName, String password,String email) {
        String role =  userName.equals("Ashish") ? "ADMIN" : "USER";
        UserEntity user = UserEntity.builder().username(userName)
                .password(passwordEncoder.encode(password))
                        .email(email).role(role).
                build();

        userEntityDao.save(user);

    }
}
