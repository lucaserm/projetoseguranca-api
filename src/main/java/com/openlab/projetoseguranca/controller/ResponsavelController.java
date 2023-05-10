package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Responsavel;
import com.openlab.projetoseguranca.repository.ResponsavelRepository;

@RequestMapping("/responsavel")
@RestController
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @PostMapping("/salvar")
    public Responsavel salvar(@RequestBody Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    @GetMapping("/listar")
    public List<Responsavel> listar() {
        return responsavelRepository.findAll();
    }
}
