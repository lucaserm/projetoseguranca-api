package com.openlab.projetoseguranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.model.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
       public List<Ocorrencia> findByEstudante(Estudante estudante);
}
