package org.example.createDTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CreateUserDTO {

    private String email;
    //
    private String firstName;
    //
    private String lastName;
    //
    private String otp;

    private String password;

    private String phoneNumber;

    private String username;
    //
    private String accessLevel1;
    //
    private String accesslevel2;
    //
    private String admin;
    //
    private String cityRural;
    //
    private String devTeam;
    //
    private String division;
    //
    private String groupName;
    //
    private String privilege;
    //
    private String prodAccess;
    //
    private String role;


}
