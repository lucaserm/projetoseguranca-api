package com.openlab.projetoseguranca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Disciplina;
import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.model.Registro;
import com.openlab.projetoseguranca.repository.DisciplinaRepository;
import com.openlab.projetoseguranca.repository.EstudanteRepository;
import com.openlab.projetoseguranca.repository.RegistroRepository;
import com.openlab.projetoseguranca.service.UsuarioService;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping("/salvar")
    public Estudante salvar(@RequestBody Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    @PostMapping("/registro/salvar/")
    public Estudante salvarRegistroEstudante(@RequestParam("id") Long id, @RequestBody Registro registro) {
        Estudante estudante = estudanteRepository.findById(id).get(); 
        registro.setEstudante(estudante);
        registroRepository.save(registro);
        estudante.getRegistros().add(registro);
        return estudanteRepository.save(estudante);
    }

    @PostMapping("/disciplina/salvar/")
    public Estudante salvarDisciplinaEstudante(
        @RequestParam("id") List<Long> ids, 
        @RequestParam("idEstudante") Long idEstudante) {
        List<Disciplina> disciplinas = new ArrayList<>();
        Estudante estudante = estudanteRepository.findById(idEstudante).get();
        for(Long id : ids){
            Disciplina disciplina = disciplinaRepository.findById(id).get();
            disciplinas.add(disciplina);
        }
        estudante.setDisciplinas(disciplinas);
        return estudanteRepository.save(estudante);
    }

    @GetMapping("/listar")
    public List<Estudante> listar() {
        return estudanteRepository.findAll();
    }
    
    @PostMapping("/buscar")
    public List<Estudante> buscarEstudante(@RequestBody Estudante estudante) {
        return usuarioService.listarEstudantesCoordencao(estudante);
    }
    
}
