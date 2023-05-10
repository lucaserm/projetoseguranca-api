package com.openlab.projetoseguranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.repository.EstudanteRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> listarEstudantesCoordencao(Estudante estudante) {
        List<Estudante> estudantes = estudanteRepository.findByNomeContains(estudante.getNome());
        if(estudanteRepository.findByRa(estudante.getRa()).isPresent()){
            estudantes.add(estudanteRepository.findByRa(estudante.getRa()).get());
        }
        if(estudanteRepository.findByCpf(estudante.getCpf()).isPresent()){
            estudantes.add(estudanteRepository.findByCpf(estudante.getCpf()).get());
        }
        return estudantes;
    }
}
