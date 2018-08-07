/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Dao;

import br.com.indieapps.capp.Models.Usuario;
import br.com.indieapps.capp.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arthur
 */
public class UsuarioDao extends Dao {
    
    //Testando Git
    
    private SessionFactory sf;
    
    public UsuarioDao(){
    
        sf = HibernateUtil.getSessionFactory();
        
    }
    
    public List<Usuario> listarUsuarios(){
    
        Session session = sf.openSession();
        Query query = session.createQuery("from Usuario order by nome");
        List<Usuario> usuarios = query.list();
        return usuarios;
        
    }
    
    public List<Usuario> verificarSeExisteUsuario(Usuario usuario){
    
        Session session = sf.openSession();
        Query query = session.createQuery("from Usuario where cpf = '" + usuario.getCpf() +"'");
        List<Usuario> usuarios = query.list();
        return usuarios;
        
    }
    
}
