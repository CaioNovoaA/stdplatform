package com.br.stdplatform.controller;

import com.br.stdplatform.model.User;
import com.br.stdplatform.repository.UserRepository;
import com.br.stdplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Autowired
    UserRepository userRepository;

    @PostMapping
    ResponseEntity<User> cadastraUsuario(@RequestBody @Valid User user) {
        userService.saveUsuario(user);
        return ResponseEntity.ok().build();
    }
}
