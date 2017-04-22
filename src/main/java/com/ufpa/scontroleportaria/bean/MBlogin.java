/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBlogin")
@ViewScoped
public class MBlogin extends AbstractBean {
        String siape;
        String senha;
    
  public String login() {
         FacesMessage message = null;
        
        if(getSiape()!= null && getSiape().equals("admin") && getSenha() != null && getSenha().equals("admin")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Bem Vindo", getSiape()));
            return "/Telas/PaginaInicial";
            
        } 
        if(getSiape()!= null && getSiape().equals("prof") && getSenha() != null && getSenha().equals("prof")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Bem Vindo", getSiape()));
            return "/Telas/funcionario/MinhasPortarias";
           
        } 
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_ERROR, "Erro!", "Verifique o Login!"));
        }
        return null;
  }    

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
       
}
