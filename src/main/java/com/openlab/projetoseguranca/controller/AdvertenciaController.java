package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Advertencia;
import com.openlab.projetoseguranca.repository.AdvertenciaRepository;

@RestController
@RequestMapping("/advertencia")
public class AdvertenciaController {

    @Autowired
    private AdvertenciaRepository advertenciaRepository;

    @PostMapping("/salvar")
    public Advertencia salvar(@RequestBody Advertencia advertencia) {
        return advertenciaRepository.save(advertencia);
    }

    @GetMapping("/listar")
    public List<Advertencia> listar() {
        return advertenciaRepository.findAll();
    }
}
