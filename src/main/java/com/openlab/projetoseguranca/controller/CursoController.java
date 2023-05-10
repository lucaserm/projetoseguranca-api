package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Curso;
import com.openlab.projetoseguranca.repository.CursoRepository;

@RequestMapping("/curso")
@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/salvar")
    public Curso salvar(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping("/listar")
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }
}
