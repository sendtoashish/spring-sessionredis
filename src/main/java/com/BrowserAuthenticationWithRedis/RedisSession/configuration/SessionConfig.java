package com.BrowserAuthenticationWithRedis.RedisSession.configuration;

import com.BrowserAuthenticationWithRedis.RedisSession.model.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
    @Bean(name = "sessionConfigRedisTemplate")
    public RedisTemplate<String, UserEntity> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        final RedisTemplate<String,UserEntity> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
  //      template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
       // template.setKeySerializer(new StringRedisSerializer());
 //       template.(new UserSerializer());
        return template;
    }
}
