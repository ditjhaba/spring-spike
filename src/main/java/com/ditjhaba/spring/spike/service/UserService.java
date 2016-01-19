package com.ditjhaba.spring.spike.service;

import com.ditjhaba.spring.spike.DTO.UserDTO;
import com.ditjhaba.spring.spike.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), new BCryptPasswordEncoder().encode(userDTO.getPassword()), userDTO.getRole());

        return userRepository.save(user);
    }
}
