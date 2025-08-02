package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.JwtUtil;
import com.example.demo.dto.LoginRequest;



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

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest request) {
        User usuario = userService.buscarPorEmail(request.getEmail());

        if (usuario == null || !userService.senhaConfere(request.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail());
        return ResponseEntity.ok("Token: " + token);
    }
}
