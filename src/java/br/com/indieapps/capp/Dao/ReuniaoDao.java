/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Dao;

import br.com.indieapps.capp.Models.Reuniao;
import br.com.indieapps.capp.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arthur
 */
public class ReuniaoDao extends Dao {
    
    SessionFactory sf;
    
    public ReuniaoDao(){
        
        sf = HibernateUtil.getSessionFactory();
        
    }
    
    public List<Reuniao> listarReunioes(){
    
        Session session = sf.openSession();
        Query query = session.createQuery("from Reuniao order by cidade.id");
        List<Reuniao> reunioes = query.list();
        return reunioes;
        
    }
    
    
}
