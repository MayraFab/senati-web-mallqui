package com.senati.senati_web_mallqui.service;

import com.senati.senati_web_mallqui.model.Response;
import com.senati.senati_web_mallqui.model.User;
import com.senati.senati_web_mallqui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> saveUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(Integer id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setLastname(updatedUser.getLastname());
            return new ResponseEntity<>(userRepository.save(existingUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        }
        public Response deleteUser(int id) {
            Optional<User> optionalUser = userRepository.findById(id);
            Response response = new Response();
            if (optionalUser.isPresent()) {
                response.setCode(200);
                response.setStatus("success");
                response.setMessage("El usuario con id: "+ id + "se ha limpiado correctamente");
                return response;
            }
            response.setCode(404);
            response.setStatus("Error");
            response.setMessage("No se puede eliminar al usuario");
            return response;
    }
}