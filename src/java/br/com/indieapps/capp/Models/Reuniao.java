/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Arthur
 */

@Entity
public class Reuniao implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtividade;
    
    private String nomeDaEquipe;
    
    private String coordenador;
    
    private String gerentes;
    
    @OneToOne
    private Cidade cidade;
    
    private String bairro;
    
    private String rua;
    
    private String numero;
    
    private String qtdParticipantes;
    
    private String qtdPresentes;
    
    private String descricaoAtividade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getNomeDaEquipe() {
        return nomeDaEquipe;
    }

    public void setNomeDaEquipe(String nomeDaEquipe) {
        this.nomeDaEquipe = nomeDaEquipe;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getGerentes() {
        return gerentes;
    }

    public void setGerentes(String gerentes) {
        this.gerentes = gerentes;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(String qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

    public String getQtdPresentes() {
        return qtdPresentes;
    }

    public void setQtdPresentes(String qtdPresentes) {
        this.qtdPresentes = qtdPresentes;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.dataAtividade);
        hash = 37 * hash + Objects.hashCode(this.nomeDaEquipe);
        hash = 37 * hash + Objects.hashCode(this.coordenador);
        hash = 37 * hash + Objects.hashCode(this.gerentes);
        hash = 37 * hash + Objects.hashCode(this.cidade);
        hash = 37 * hash + Objects.hashCode(this.bairro);
        hash = 37 * hash + Objects.hashCode(this.rua);
        hash = 37 * hash + Objects.hashCode(this.numero);
        hash = 37 * hash + Objects.hashCode(this.qtdParticipantes);
        hash = 37 * hash + Objects.hashCode(this.qtdPresentes);
        hash = 37 * hash + Objects.hashCode(this.descricaoAtividade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reuniao other = (Reuniao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeDaEquipe, other.nomeDaEquipe)) {
            return false;
        }
        if (!Objects.equals(this.coordenador, other.coordenador)) {
            return false;
        }
        if (!Objects.equals(this.gerentes, other.gerentes)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.qtdParticipantes, other.qtdParticipantes)) {
            return false;
        }
        if (!Objects.equals(this.qtdPresentes, other.qtdPresentes)) {
            return false;
        }
        if (!Objects.equals(this.descricaoAtividade, other.descricaoAtividade)) {
            return false;
        }
        if (!Objects.equals(this.dataAtividade, other.dataAtividade)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }
    

  
}
