/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Bean;

import br.com.indieapps.capp.Dao.ReuniaoDao;
import br.com.indieapps.capp.Models.Reuniao;
import br.com.indieapps.capp.Util.MessagesUtil;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author arthur
 */
@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable {

    private boolean renderForm, renderList, renderMenu, renderBtnCadastrar, renderBtnAlterar;
    private List<Reuniao> reunioes;
    private Reuniao reuniao;
    private ReuniaoDao dao;

    public AtividadeBean() {

        renderForm = false;
        renderList = false;
        renderMenu = true;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;
        reuniao = new Reuniao();

    }

    public void prepararCadastro() {

        reuniao = new Reuniao();
        renderForm = true;
        renderList = false;
        renderMenu = false;
        renderBtnCadastrar = true;
        renderBtnAlterar = false;
    }

    public void prepararAlterar(Reuniao reuniao) {

        this.reuniao = reuniao;
        renderForm = true;
        renderList = false;
        renderMenu = false;
        renderBtnCadastrar = false;
        renderBtnAlterar = true;

    }

    public void remover(Reuniao reuniao) {

        dao.deletar(reuniao);
        reunioes = dao.listarReunioes();
        MessagesUtil.addInfoMsg("Reunião removida com sucesso", "");

    }

    public void cadastrar() throws NoSuchAlgorithmException {

        dao.cadastrar(reuniao);
        reuniao = new Reuniao();
        MessagesUtil.addInfoMsg("Usuario cadastrado com sucesso!", "");

    }

    public void alterar() throws NoSuchAlgorithmException {

     

            dao.alterar(reuniao);
            reunioes = dao.listarReunioes();
            MessagesUtil.addInfoMsg("Reuniao alterada com sucesso!", "");

    }

    public void cancelar() {

        renderMenu = true;
        renderForm = false;
        renderList = false;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;

    }

    public void listarReunioes() {

        renderForm = false;
        renderMenu = false;
        renderList = true;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;
        reunioes = dao.listarReunioes();

    }

}
