/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.controller;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.DAO.SessionUtils;

/**
 *
 * @author andreismiths
 */
public class VariaveisDeSessao {

    public Object getObjetoTemp() {
        return (Object) SessionUtils.getSession().getAttribute("objetoTemporario");
    }

    public void setObjetoTemp(Object objeto) {
        SessionUtils.getSession().setAttribute("objetoTemporario", objeto);
    }
    
    public Funcionario objetoFuncionario(){
        return (Funcionario) SessionUtils.getSession().getAttribute("objetoTemporario");
    }
    //-------------//
    
    public void setDadosFuncionario(Object objFuncionario){
        Funcionario obj = (Funcionario) objFuncionario;
        SessionUtils.getSession().setAttribute("username", new BeautyText().fistNLast(obj.getNomeFuncionario()));
        SessionUtils.getSession().setAttribute("dadosFuncionario", objFuncionario);
    }
    
    public Funcionario getDadosFuncionario(){
        return (Funcionario) SessionUtils.getSession().getAttribute("dadosFuncionario");
    }
    
    public String getUsername(){
        return (String) SessionUtils.getSession().getAttribute("username");
    }
    
        public String getEmail(){
        return (String) getDadosFuncionario().getEmailFuncionario();
    }
    
    public String getTipoFuncionario(){
        return (String) getDadosFuncionario().getTipoFuncionario();
    }
}
