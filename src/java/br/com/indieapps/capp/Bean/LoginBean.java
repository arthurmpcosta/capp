/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Bean;

import br.com.indieapps.capp.Dao.UsuarioDao;
import br.com.indieapps.capp.Models.Usuario;
import br.com.indieapps.capp.Util.MessagesUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public LoginBean() {

        usuario = new Usuario();
        usuarioDao = new UsuarioDao();

    }

    public String realizarLogin() throws NoSuchAlgorithmException {

        usuario.setSenha(criptografaSenha(usuario.getSenha().toUpperCase()));
        List<Usuario> usuarios = usuarioDao.verificarSeExisteUsuario(usuario);
        
        if (usuarios.size() > 0) {

            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("admin", usuarios.get(0));
            return "menu.jsf?faces-redirect=true";

        } else {

            MessagesUtil.addInfoAlert("CPF e/ou Senha inválidos!", "");

            return "";
        }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    

}
