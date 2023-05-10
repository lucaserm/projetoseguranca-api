package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Registro;
import com.openlab.projetoseguranca.repository.RegistroRepository;

@RequestMapping("/registro")
@RestController
public class RegistroController {
    
    @Autowired
    private RegistroRepository registroRepository;

    @PostMapping("/salvar")
    public Registro salvar(@RequestBody Registro registro) {
        return registroRepository.save(registro);
    }

    @GetMapping("/listar")
    public List<Registro> listar() {
        return registroRepository.findAll();
    }
}
