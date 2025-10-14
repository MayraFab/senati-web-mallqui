package com.senati.senati_web_mallqui.service;

import com.senati.senati_web_mallqui.model.User;
import com.senati.senati_web_mallqui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List <User> getAllUsers(){
        return userRepository.findAll();
    }
}

    public ResponseEntity<User> newUser (User user) {
        return new ResponseEntity<>(userRepository.save(user). HttpStatus.OK);
    }

    public ResponseEntity<User> newUser(@RequestBody User user) {
        return userService.newUser(user);
    }