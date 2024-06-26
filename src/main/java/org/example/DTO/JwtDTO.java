package org.example.DTO;

import lombok.Data;
import org.example.response.JwtResponse;

@Data
public class JwtDTO {
    private JwtResponse jwtResponse;

    public JwtDTO(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }

    public JwtResponse getJwtResponse() {
        return jwtResponse;
    }

    public void setJwtResponse(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }
}
