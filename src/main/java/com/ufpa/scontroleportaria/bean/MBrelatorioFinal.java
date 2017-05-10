/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.controller.RelatorioFList;
import com.ufpa.scontroleportaria.model.RelatorioF;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBrelatorioF")
@ViewScoped
public class MBrelatorioFinal extends AbstractBean {
    
    private RelatorioF relatorioF;
    private RelatorioFList objListRelatorioF;
    
    
    public void cadastrarRelatorioF() {
        try {
            getDaoGenerico().save(relatorioF);
            getObjMessage().info("Cadastro efetuado!", "Relatório Final cadastrado com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
        
    }

    public RelatorioF getRelatorioF() {
        if (relatorioF == null) {
            relatorioF = new RelatorioF();
        }
        return relatorioF;
    }

    public void setRelatorioF(RelatorioF relatorioF) {
        this.relatorioF = relatorioF;
    }

    public RelatorioFList getObjListRelatorioF() {
        if (objListRelatorioF == null) {
            objListRelatorioF = new RelatorioFList();
        }
        return objListRelatorioF;
    }

    public void setObjListRelatorioF(RelatorioFList objListRelatorioF) {
        this.objListRelatorioF = objListRelatorioF;
    }
    
}

    