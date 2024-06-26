package org.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "payroll_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", length = 255)
    private String email;
    //
    @Column(name = "firstname", length = 255)
    private String firstName;

    @Column(name = "lastname", length = 255)
    private String lastName;

    @Column(name = "otp", length = 255)
    private String otp;
    //
    @Column(name = "password", length = 255)
    private String password;
    //
    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "accesslevel1")
    private String accessLevel1;

    @Column(name = "accesslevel2", length = 255)
    private String accesslevel2;

    @Column(name = "admin", length = 255)
    private String admin;

    @Column(name = "citynrural", length = 255)
    private String cityRural;

    @Column(name = "devteam", length = 255)
    private String devTeam;

    @Column(name = "division", length = 255)
    private String division;

    @Column(name = "group_name", length = 255)
    private String groupName;

    @Column(name = "privilege", length = 255)
    private String privilege;

    @Column(name = "prodaccess", length = 255)
    private String prodAccess;

    @Column(name = "role", length = 255)
    private String role;
}
