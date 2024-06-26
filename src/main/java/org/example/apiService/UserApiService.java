package org.example.apiService;

import org.example.DTO.UserDTO;
import org.example.Service.UserService;
import org.example.createDTO.CreateUserDTO;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserApiService {
    private final UserService userService;

    private final UserMapper userMapper;

    public UserApiService(UserService userService, UserMapper userMapper) {
        super();
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserDTO save(CreateUserDTO createUserDTO) {
        // TODO Auto-generated method stub
        return userMapper.modelToDto(userService.create(userMapper.createDtoToModel(createUserDTO)));
    }


}
