package com.openlab.projetoseguranca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.openlab.projetoseguranca.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  public Usuario findByCodigo(String codigo);
}
