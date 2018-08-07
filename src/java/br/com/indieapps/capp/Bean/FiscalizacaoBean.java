/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Bean;

import br.com.indieapps.capp.Models.Fiscalizacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean
@ViewScoped
public class FiscalizacaoBean implements Serializable {

    private Fiscalizacao fiscalizacao;
    private List<Fiscalizacao> fiscalizacoes;
    private List<String> fiscais;

    public FiscalizacaoBean() {

        fiscalizacoes = new ArrayList<Fiscalizacao>();
        fiscais = new ArrayList<String>();

        fiscalizacao = new Fiscalizacao();
        fiscalizacao.setId(1020);
        fiscalizacao.setZona("003");
        fiscalizacao.setSecao("007");
        fiscalizacao.setBairro("Cristo Redentor");
        fiscalizacao.setRua("Rua Dom Bosco");
        fiscalizacao.setNumero("391");
        fiscalizacao.setCoordenador("Paulo");

        fiscalizacoes.add(fiscalizacao);

        fiscalizacao = new Fiscalizacao();
        fiscalizacao.setId(1030);
        fiscalizacao.setZona("006");
        fiscalizacao.setSecao("010");
        fiscalizacao.setBairro("Castelo Branco");
        fiscalizacao.setRua("Eduardo Medeiros");
        fiscalizacao.setNumero("44");
        fiscalizacao.setCoordenador("Hugo");

        fiscalizacoes.add(fiscalizacao);

        fiscalizacao = new Fiscalizacao();
        fiscalizacao.setId(1040);
        fiscalizacao.setZona("012");
        fiscalizacao.setSecao("033");
        fiscalizacao.setBairro("Mangabeira VII");
        fiscalizacao.setRua("Renato Gomes de Oliveira");
        fiscalizacao.setNumero("230");
        fiscalizacao.setCoordenador("Feuber");

        fiscalizacoes.add(fiscalizacao);
        fiscais.add("Arthur");
        fiscais.add("Djair");
        fiscais.add("Feuber");
        fiscais.add("Hugo");
        fiscais.add("Paulo");

    }

    public Fiscalizacao getFiscalizacao() {
        return fiscalizacao;
    }

    public void setFiscalizacao(Fiscalizacao fiscalizacao) {
        this.fiscalizacao = fiscalizacao;
    }

    public List<Fiscalizacao> getFiscalizacoes() {
        return fiscalizacoes;
    }

    public void setFiscalizacoes(List<Fiscalizacao> fiscalizacoes) {
        this.fiscalizacoes = fiscalizacoes;
    }

    public List<String> getFiscais() {
        return fiscais;
    }

    public void setFiscais(List<String> fiscais) {
        this.fiscais = fiscais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.fiscalizacao);
        hash = 79 * hash + Objects.hashCode(this.fiscalizacoes);
        hash = 79 * hash + Objects.hashCode(this.fiscais);
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
        final FiscalizacaoBean other = (FiscalizacaoBean) obj;
        if (!Objects.equals(this.fiscalizacao, other.fiscalizacao)) {
            return false;
        }
        if (!Objects.equals(this.fiscalizacoes, other.fiscalizacoes)) {
            return false;
        }
        if (!Objects.equals(this.fiscais, other.fiscais)) {
            return false;
        }
        return true;
    }

}
