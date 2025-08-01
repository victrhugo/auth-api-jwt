package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.emailJaExiste(user.getEmail())) {
            return ResponseEntity.badRequest().body("E-mail já existente.");
        }

        User novoUsuario = userService.salvar(user);
        return ResponseEntity.ok("Usuário cadastrado com sucesso: " + novoUsuario.getEmail());
    }
}
