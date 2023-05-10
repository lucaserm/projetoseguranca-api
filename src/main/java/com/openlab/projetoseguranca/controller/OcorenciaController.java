package com.openlab.projetoseguranca.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.model.Ocorrencia;
import com.openlab.projetoseguranca.model.Usuario;
import com.openlab.projetoseguranca.repository.EstudanteRepository;
import com.openlab.projetoseguranca.repository.OcorrenciaRepository;
import com.openlab.projetoseguranca.repository.UsuarioRepository;

@RequestMapping("/ocorrencia")
@RestController
public class OcorenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    /* @PostMapping("/salvar")
    public Ocorrencia salvar(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    } */

    @GetMapping("/listar")
    public List<Ocorrencia> listar() {
        return ocorrenciaRepository.findAll();
    }

    @PostMapping("/salvar")
    public Ocorrencia salvarOcorrencia(@RequestBody Ocorrencia ocorrencia){
        Date data = new Date();
        ocorrencia.setData_ocorrencia(data);
        Estudante estudanteBanco = estudanteRepository.findById(ocorrencia.getEstudante().getId()).get();
        estudanteBanco.getOcorrencias().add(ocorrencia);
        estudanteRepository.save(estudanteBanco);
        Usuario usuario = usuarioRepository.findById(ocorrencia.getUsuario().getId()).get();
        usuario.getOcorrencias().add(ocorrencia);
        usuarioRepository.save(usuario); 
        return ocorrenciaRepository.save(ocorrencia);
    }

    @GetMapping("/listar/{id}")
    public List<Ocorrencia> listarOcorrenciaPorIdEstudante(@PathVariable("id") Long id){
        return ocorrenciaRepository.findByEstudante(estudanteRepository.findById(id).get());
    }

}
