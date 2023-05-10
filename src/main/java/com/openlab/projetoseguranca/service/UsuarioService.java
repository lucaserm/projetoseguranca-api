package com.openlab.projetoseguranca.service;

import java.util.List;

import com.openlab.projetoseguranca.model.Estudante;

public interface UsuarioService {

    public List<Estudante> listarEstudantesCoordencao(Estudante estudante);

}
