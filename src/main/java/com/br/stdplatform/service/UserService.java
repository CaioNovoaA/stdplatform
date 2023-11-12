package com.br.stdplatform.service;

import com.br.stdplatform.model.User;
import com.br.stdplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User saveUsuario(User user) {
        try {
            return userRepository.save(user);
        } catch (EntityNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
