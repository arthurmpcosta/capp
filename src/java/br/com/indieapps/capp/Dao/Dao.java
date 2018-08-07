/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Dao;

import br.com.indieapps.capp.Util.HibernateUtil;
import br.com.indieapps.capp.Util.MessagesUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *  
 * @author Arthur
 * 
 */
public class Dao {

    private SessionFactory sf;

    public Dao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public boolean cadastrar(Object objeto) {
        Session sessao = sf.openSession();
        try {
            Transaction t = sessao.beginTransaction();
            sessao.save(objeto);
            t.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            sessao.close();
        }
    }

    public boolean alterar(Object objeto) {
        Session sessao = sf.openSession();
        try {
            Transaction t = sessao.beginTransaction();
            sessao.update(objeto);
            t.commit();
            return true;
        } catch (Exception e) {
            MessagesUtil.addErroMsg("Error : " + e.getMessage(), "");
            return false;
        } finally {
            sessao.close();
        }
    }

    public boolean deletar(Object objeto) {
        Session sessao = sf.openSession();
        try {
            Transaction t = sessao.beginTransaction();
            sessao.delete(objeto);
            t.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            sessao.close();
        }
    }
}
