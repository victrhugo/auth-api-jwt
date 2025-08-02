package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User salvar(User user) {
        user.setSenha(encoder.encode(user.getSenha()));
        return repository.save(user);
    }

    public boolean emailJaExiste(String email) {
        return repository.existsByEmail(email);
    }

    public User buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public boolean senhaConfere(String senhaBruta, String senhaCodificada) {
        return encoder.matches(senhaBruta, senhaCodificada);
    }
}
