/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Dao;

import br.com.indieapps.capp.Models.Cidade;
import br.com.indieapps.capp.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arthur
 */
public class CidadeDao extends Dao {
    
    private SessionFactory sf;
    
    public CidadeDao(){
        
        sf = HibernateUtil.getSessionFactory();
        
    }
    
    public List<Cidade> listarCidades(){
    
        Session session = sf.openSession();
        Query query = session.createQuery("from Cidade order by id");
        List<Cidade> cidades = query.list();
        return cidades;
        
    }
    
}
