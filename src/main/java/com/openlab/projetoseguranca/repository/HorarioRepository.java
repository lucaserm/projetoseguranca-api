package com.openlab.projetoseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.openlab.projetoseguranca.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
