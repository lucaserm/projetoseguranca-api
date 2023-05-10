package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Disciplina;
import com.openlab.projetoseguranca.repository.DisciplinaRepository;

@RequestMapping("/disciplina")
@RestController
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping("/salvar")
    public Disciplina disciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @GetMapping("/listar")
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }
}
