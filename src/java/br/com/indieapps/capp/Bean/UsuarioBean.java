/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Bean;

import br.com.indieapps.capp.Dao.UsuarioDao;
import br.com.indieapps.capp.Models.Usuario;
import br.com.indieapps.capp.Util.MessagesUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private boolean renderSelecionarCidade;
    private boolean renderForm, renderList, renderMenu, renderBtnCadastrar, renderBtnAlterar;
    private UsuarioDao dao;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String confirmarSenha;

    public UsuarioBean() {

        renderSelecionarCidade = true;
        renderForm = false;
        renderList = false;
        renderMenu = true;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;
        dao = new UsuarioDao();
        usuario = new Usuario();

    }

    public void prepararCadastro() {

        usuario = new Usuario();
        renderForm = true;
        renderList = false;
        renderMenu = false;
        renderBtnCadastrar = true;
        renderBtnAlterar = false;
    }

    public void prepararAlterar(Usuario usuario) {

        this.usuario = usuario;
        renderForm = true;
        renderList = false;
        renderMenu = false;
        renderBtnCadastrar = false;
        renderBtnAlterar = true;

    }

    public void remover(Usuario usuario) {

        dao.deletar(usuario);
        usuarios = dao.listarUsuarios();
        MessagesUtil.addInfoMsg("Usuario removido com sucesso", "");

    }

    public void cadastrar() throws NoSuchAlgorithmException {

        if (usuario.getSenha().equals(confirmarSenha)) {

            usuario.setNome(usuario.getNome().toUpperCase());
            usuario.setSenha(usuario.getSenha().toUpperCase());
            usuario.setSenha(criptografaSenha(usuario.getSenha()));
            List<Usuario> usuariosVer = dao.verificarSeExisteUsuario(usuario);
            
            if (usuariosVer.size() > 0) {

                MessagesUtil.addInfoMsg("CPF já Cadastrado, insira um CPF diferente!", "");

            } else {
                
                dao.cadastrar(usuario);
                usuario = new Usuario();
                MessagesUtil.addInfoMsg("Usuario cadastrado com sucesso!", "");
            }

        } else {

            MessagesUtil.addInfoAlert("Senha e confirmação de Senha são diferentes", "");

        }

    }

    public void alterar() throws NoSuchAlgorithmException {

        if (usuario.getSenha().equals(confirmarSenha)) {

            usuario.setNome(usuario.getNome().toUpperCase());
            usuario.setSenha(usuario.getSenha().toUpperCase());
            usuario.setSenha(criptografaSenha(usuario.getSenha()));

            dao.alterar(usuario);
            MessagesUtil.addInfoMsg("Usuario alterado com sucesso!", "");

        } else {

            MessagesUtil.addInfoAlert("Senha e confirmação de Senha são diferentes", "");

        }

        listarUsuarios();

    }

    public void cancelar() {

        renderMenu = true;
        renderForm = false;
        renderList = false;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;

    }

    public void listarUsuarios() {

        renderForm = false;
        renderMenu = false;
        renderList = true;
        renderBtnCadastrar = false;
        renderBtnAlterar = false;
        usuarios = dao.listarUsuarios();

    }
    
    public void selecionarCidade(){
    
        renderSelecionarCidade = false;
        MessagesUtil.addInfoMsg("Você agora está trabalhando na Cidade de " + usuario.getCidade().getNome(), confirmarSenha);
        
    }

    public String criptografaSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        String s = hash.toString(16);
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        return s;
    }

    public boolean isRenderForm() {
        return renderForm;
    }

    public void setRenderForm(boolean renderForm) {
        this.renderForm = renderForm;
    }

    public boolean isRenderBtnCadastrar() {
        return renderBtnCadastrar;
    }

    public void setRenderBtnCadastrar(boolean renderBtnCadastrar) {
        this.renderBtnCadastrar = renderBtnCadastrar;
    }

    public boolean isRenderBtnAlterar() {
        return renderBtnAlterar;
    }

    public void setRenderBtnAlterar(boolean renderBtnAlterar) {
        this.renderBtnAlterar = renderBtnAlterar;
    }

    public boolean isRenderList() {
        return renderList;
    }

    public void setRenderList(boolean renderList) {
        this.renderList = renderList;
    }

    public UsuarioDao getDao() {
        return dao;
    }

    public void setDao(UsuarioDao dao) {
        this.dao = dao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isRenderMenu() {
        return renderMenu;
    }

    public void setRenderMenu(boolean renderMenu) {
        this.renderMenu = renderMenu;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public boolean isRenderSelecionarCidade() {
        return renderSelecionarCidade;
    }

    public void setRenderSelecionarCidade(boolean renderSelecionarCidade) {
        this.renderSelecionarCidade = renderSelecionarCidade;
    }
    
    

}
