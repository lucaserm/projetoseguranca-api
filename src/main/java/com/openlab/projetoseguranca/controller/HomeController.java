package com.openlab.projetoseguranca.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Usuario;
import com.openlab.projetoseguranca.repository.UsuarioRepository;

@RestController
public class HomeController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @RequestMapping("/")
    public ResponseBody index() {
        return null;
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioRepository.findByCodigo(usuario.getCodigo());
    }
}
