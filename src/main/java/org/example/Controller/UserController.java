package org.example.Controller;


import org.example.DTO.UserDTO;
import org.example.createDTO.CreateUserDTO;
import org.example.utils.RestResponse;
import org.example.utils.RestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.apiService.UserApiService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "https://payrollapi.tnhb.in", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200", "https://payrollapi.tnhb.in", "https://employee-corner.tnhb.in"}, allowedHeaders = "*")

public class UserController {

    private final UserApiService userApiService;

    public UserController(UserApiService userApiService) {
        super();
        this.userApiService = userApiService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<RestResponse<UserDTO>> save(@RequestBody CreateUserDTO createUserDTO) {

        return RestUtils.successResponse(userApiService.save(createUserDTO));

    }

}
