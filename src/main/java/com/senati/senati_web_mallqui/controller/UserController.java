package com.senati.senati_web_mallqui.controller;

import com.senati.senati_web_mallqui.model.User;
import com.senati.senati_web_mallqui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/actualizar/{id}")
    public User actualizar(@PathVariable Long id, @RequestBody User user) {
        return userService.actualizarUsuario(id, user);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        userService.eliminarUsuario(id);
    }
}
