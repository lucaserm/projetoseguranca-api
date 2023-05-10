package com.openlab.projetoseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openlab.projetoseguranca.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

}
