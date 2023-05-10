package com.openlab.projetoseguranca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Horario {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String periodo;
    
    private String dia_semana;

    private int tempo_inicio;

    private int tempo_fim;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @JsonIgnore
    private Disciplina disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public int getTempo_inicio() {
        return tempo_inicio;
    }

    public void setTempo_inicio(int tempo_inicio) {
        this.tempo_inicio = tempo_inicio;
    }

    public int getTempo_fim() {
        return tempo_fim;
    }

    public void setTempo_fim(int tempo_fim) {
        this.tempo_fim = tempo_fim;
    }
    
    public Disciplina getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }
    
}
