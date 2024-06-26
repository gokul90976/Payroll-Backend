package org.example.Controller;

import org.example.DTO.JwtDTO;
import org.example.DTO.LoginRequestDTO;
import org.example.apiService.AuthApiService;
import org.example.utils.RestResponse;
import org.example.utils.RestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "https://payrollapi.tnhb.in", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200", "https://payrollapi.tnhb.in", "https://employee-corner.tnhb.in"}, allowedHeaders = "*")


public class AuthController {

    private final AuthApiService authApiService;

    public AuthController(AuthApiService authApiService) {
        super();
        this.authApiService = authApiService;
    }

    @PostMapping("/auth/signIn")
    public ResponseEntity<RestResponse<JwtDTO>> save(@RequestBody LoginRequestDTO loginRequestDTO) {

        return RestUtils.successResponse(authApiService.authenticateUser(loginRequestDTO));

    }

}
