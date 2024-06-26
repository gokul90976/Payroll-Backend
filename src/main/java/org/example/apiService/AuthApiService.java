package org.example.apiService;

import org.example.DTO.JwtDTO;
import org.example.DTO.LoginRequestDTO;
import org.example.Repo.UserRepo;
import org.example.Service.UserDetailsImpl;
import org.example.jwt.JwtUtils;
import org.example.response.JwtResponse;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;

@Service
public class AuthApiService {

    private final UserRepo userRepository;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;


    public AuthApiService(UserRepo userRepository, JwtUtils jwtUtils,
                          AuthenticationManager authenticationManager) {
        super();
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public JwtDTO authenticateUser(LoginRequestDTO loginRequestDTO) {


        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

        // Get user details
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Set the authentication in the Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        String jwt = jwtUtils.generateJwtToken(userDetails);

        // Create JwtResponse object
        JwtResponse jwtResponse = new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getRole());

        // Return JwtDTO object
        return new JwtDTO(jwtResponse);
    }
}
