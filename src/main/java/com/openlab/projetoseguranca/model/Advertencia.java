package com.openlab.projetoseguranca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Advertencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relatorio_advertencia;

    private Date data_resolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocorrencia_id")
    private Ocorrencia ocorrencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Date getData_resolucao() {
        return data_resolucao;
    }

    public void setData_resolucao(Date data_resolucao) {
        this.data_resolucao = data_resolucao;
    }

    public String getRelatorio_advertencia() {
        return relatorio_advertencia;
    }

    public void setRelatorio_advertencia(String relatorio_advertencia) {
        this.relatorio_advertencia = relatorio_advertencia;
    }
}
