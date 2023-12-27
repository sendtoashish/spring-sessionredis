package com.BrowserAuthenticationWithRedis.RedisSession.Filter;

import com.BrowserAuthenticationWithRedis.RedisSession.DAO.UserDao;
import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

public class FirstFilter extends OncePerRequestFilter {

   @Autowired
   UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpSession session =  request.getSession();
        if(session == null || session.getAttribute("user") != null){
            User suser = (User)session.getAttribute("user");
            System.out.println(suser.getUserName());
            filterChain.doFilter(request, response);
        }else{
            response.sendRedirect("/login");
        }


            }
    }

