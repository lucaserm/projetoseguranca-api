package com.openlab.projetoseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openlab.projetoseguranca.model.Advertencia;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, Long>{
    
}
