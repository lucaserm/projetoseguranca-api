package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Horario;
import com.openlab.projetoseguranca.repository.HorarioRepository;

@RequestMapping("/horario")
@RestController
public class HorarioController {
    @Autowired
    private HorarioRepository horarioRepository;

    @PostMapping("/salvar")
    public Horario salvar(@RequestBody Horario horario) {
        return horarioRepository.save(horario);
    }

    @PostMapping("/salvar/{id}")
    public Horario salvar(@RequestParam("id") long id, @RequestBody Horario horario) {
        horario.getDisciplina().setId(id);
        return horarioRepository.save(horario);
    }

    @GetMapping("/listar")
    public List<Horario> listar() {
        return horarioRepository.findAll();
    }
}
