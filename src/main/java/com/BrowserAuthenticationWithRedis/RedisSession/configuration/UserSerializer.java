package com.BrowserAuthenticationWithRedis.RedisSession.configuration;

import com.BrowserAuthenticationWithRedis.RedisSession.model.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.IOException;

public class UserSerializer implements RedisSerializer<User> {

    private final ObjectMapper objectMapper;
    public UserSerializer() {
 //       this.objectMapper = new ObjectMapper();
        this.objectMapper = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
   }
    @Override
    public byte[] serialize(User user) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User deserialize(byte[] bytes) throws SerializationException {
        if(bytes==null){
            return null;
        }
        try {
            return objectMapper.readValue(bytes,User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
