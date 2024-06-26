package org.example.mapper;

import org.example.DTO.UserDTO;
import org.example.Entity.User;
import org.example.createDTO.CreateUserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PasswordEncoder encoder;


    public UserMapper(PasswordEncoder encoder) {
        super();
        this.encoder = encoder;
    }

    public User createDtoToModel(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(encoder.encode(createUserDTO.getPassword()));
        user.setAccessLevel1(createUserDTO.getAccessLevel1());
        user.setAccesslevel2(createUserDTO.getAccesslevel2());
        user.setDivision(createUserDTO.getDivision());
        user.setDevTeam(createUserDTO.getDevTeam());
        user.setCityRural(createUserDTO.getCityRural());
        user.setEmail(createUserDTO.getEmail());
        user.setGroupName(createUserDTO.getGroupName());
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setOtp(createUserDTO.getOtp());
        user.setPhoneNumber(createUserDTO.getPhoneNumber());
        user.setAdmin(createUserDTO.getAdmin());
        user.setPrivilege(createUserDTO.getPrivilege());
        user.setProdAccess(createUserDTO.getProdAccess());
        user.setRole(createUserDTO.getRole());
        return user;
    }

    public UserDTO modelToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setId(user.getId());
        dto.setAdmin(user.getAdmin());
        dto.setPassword(user.getPassword());
        dto.setDevTeam(user.getDevTeam());
        dto.setAccesslevel2(user.getAccesslevel2());
        dto.setAccessLevel1(user.getAccessLevel1());
        dto.setDivision(user.getDivision());
        dto.setEmail(user.getEmail());
        dto.setOtp(user.getOtp());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setCityRural(user.getCityRural());
        dto.setGroupName(user.getGroupName());
        dto.setPrivilege(user.getPrivilege());
        dto.setProdAccess(user.getProdAccess());
        dto.setRole(user.getRole());
        return dto;
    }

}
