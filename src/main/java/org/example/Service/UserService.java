package org.example.Service;

import org.example.Entity.User;
import org.example.Repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User create(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

}