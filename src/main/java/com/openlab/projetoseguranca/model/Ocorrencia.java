package com.openlab.projetoseguranca.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity
public class Ocorrencia {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_ocorrencia;

    private String nome_usuario_relacionado;

    private String relatorio;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocorrencia_id")
    private Usuario usuario;

    @OneToOne(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
    private Advertencia advertencia;

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Advertencia getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(Advertencia advertencia) {
        this.advertencia = advertencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome_usuario_relacionado() {
        return nome_usuario_relacionado;
    }

    public void setNome_usuario_relacionado(String nome_usuario_relacionado) {
        this.nome_usuario_relacionado = nome_usuario_relacionado;
    }

    public Date getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Date data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    
}
