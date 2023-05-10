package com.openlab.projetoseguranca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openlab.projetoseguranca.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    public Optional<Estudante> findByCpf(String cpf);

    public Optional<Estudante> findByRa(String ra);

    public List<Estudante> findByNomeContains(String nome);

}
