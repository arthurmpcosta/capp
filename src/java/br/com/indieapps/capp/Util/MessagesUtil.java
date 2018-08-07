/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.indieapps.capp.Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arthur
 */
public class MessagesUtil {

    public static void addInfoMsg(String msg1, String msg2) {
        FacesContext.getCurrentInstance().addMessage("info", new FacesMessage(FacesMessage.SEVERITY_INFO, msg1, msg2));
    }
    public static void addInfoAlert(String msg1, String msg2) {
        FacesContext.getCurrentInstance().addMessage("alert", new FacesMessage(FacesMessage.SEVERITY_WARN, msg1, msg2));
    }

    public static void addErroMsg(String msg1, String msg2) {
        FacesContext.getCurrentInstance().addMessage("erro", new FacesMessage(FacesMessage.SEVERITY_INFO, msg1, msg2));
    }
}
