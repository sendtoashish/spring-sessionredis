package com.BrowserAuthenticationWithRedis.RedisSession.DAO;

import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity,Long> {
   @Query("SELECT u FROM user_form_data u WHERE u.username= :username" )
   UserEntity findUserbyUsername(String username);
}
