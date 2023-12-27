package com.BrowserAuthenticationWithRedis.RedisSession.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialPayload implements Serializable {

    private String userName;
    private String password;
}
