package org.example.response;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private long id;
    private String username;
    private String role;


    public JwtResponse(String token, long id, String username, String role) {
        super();
        this.token = token;
        this.type = type;
        this.id = id;
        this.role = role;
        this.username = username;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}