/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.Molde;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.model.RelatorioF;

import java.io.Serializable;

/**
 *
 * @author thiberius
 */
public class CollectionClasses implements Serializable {
    
    private Funcionario funcionario;
    private Portaria portaria;
    private RelatorioF relatoriof;
    
    
    public void geraObj(){
        funcionario = new Funcionario();
        portaria = new Portaria();
        relatoriof = new RelatorioF();
    }

    public Funcionario getFuncionario() {
        if(funcionario == null){
            funcionario  =  new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Portaria getPortaria() {
        if(portaria == null){
            portaria = new Portaria();
        }
        return portaria;
    }

    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }

    public RelatorioF getRelatoriof() {
        if(relatoriof == null){
            relatoriof = new RelatorioF();
        }
        return relatoriof;
    }

    public void setRelatoriof(RelatorioF relatoriof) {
        this.relatoriof = relatoriof;
    }



}
