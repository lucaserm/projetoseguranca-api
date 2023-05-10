package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Usuario;
import com.openlab.projetoseguranca.repository.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public Usuario listarUsuarioPorId(@RequestParam Long id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

}
