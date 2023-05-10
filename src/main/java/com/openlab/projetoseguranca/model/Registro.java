package com.openlab.projetoseguranca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dia_hora_saida;

    private String descricao;

    private String dia_liberacao;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    @JsonIgnore
    private Estudante estudante;

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDia_hora_saida() {
        return dia_hora_saida;
    }

    public void setDia_hora_saida(Date dia_hora_saida) {
        this.dia_hora_saida = dia_hora_saida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDia_liberacao() {
        return dia_liberacao;
    }

    public void setDia_liberacao(String dia_liberacao) {
        this.dia_liberacao = dia_liberacao;
    }

}
