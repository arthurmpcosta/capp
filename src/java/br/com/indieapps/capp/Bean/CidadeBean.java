/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Bean;

import br.com.indieapps.capp.Dao.CidadeDao;
import br.com.indieapps.capp.Models.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Arthur
 */

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

    private Cidade cidade;
    private List<Cidade> cidades;
    private CidadeDao dao;

    public CidadeBean() {

        cidade = new Cidade();
        dao = new CidadeDao();
        
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        cidades = dao.listarCidades();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

}
