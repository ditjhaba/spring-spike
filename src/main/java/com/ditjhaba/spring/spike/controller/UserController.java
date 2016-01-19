package com.ditjhaba.spring.spike.controller;

import com.ditjhaba.spring.spike.DTO.UserDTO;
import com.ditjhaba.spring.spike.model.User;
import com.ditjhaba.spring.spike.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@EnableAutoConfiguration
@Transactional
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(UserDTO userDTO) {
        System.out.println("*************************************");
        System.out.println(userDTO);
        System.out.println("*************************************");

        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
    }
}
