package com.BrowserAuthenticationWithRedis.RedisSession.Service;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserEntityDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityDao userEntityDao;
    @Autowired
    private HttpSession httpSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityDao.findUserbyUsername(username);
        setUserAttribute(userEntity,httpSession);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword()) // Assuming the password is already encoded
                .roles(userEntity.getRole()) // Add roles as needed
                .build();
    }

    public void setUserAttribute(UserEntity user,HttpSession httpSession){
        httpSession.setAttribute("user",user);
    }


}
