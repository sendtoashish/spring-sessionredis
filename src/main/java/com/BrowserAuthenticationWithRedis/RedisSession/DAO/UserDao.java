package com.BrowserAuthenticationWithRedis.RedisSession.DAO;

import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("SELECT u FROM user_details  u WHERE u.userName= :username" )
    public User findUserbyUsername(String username);
}
