/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.controller;

import com.ufpa.scontroleportaria.bean.AbstractBean;
import com.ufpa.scontroleportaria.model.RelatorioF;
import java.util.List;

/**
 *
 * @author andreismiths
 */
public class RelatorioFList extends AbstractBean {
   
    private RelatorioF relatorioF;
    private List<RelatorioF> listRelatorioF;
    private String tipoPesquisaRelatorioF;
    private String textoPesquisaRelatorioF;

    
    public void listRelatorioF() {
        listRelatorioF = getDaoGenerico().
                list("select r from RelatorioF r where "
                        + "r." + tipoPesquisaRelatorioF + " like '%" + textoPesquisaRelatorioF + "%'");
        if (!listRelatorioF.isEmpty()) {
            getObjMessage().warn("Item não encontrado!", "O Relatório Final não foi encontrado.");
        }
    }

    public RelatorioF getRelatorioF() {
        return relatorioF;
    }

    public void setRelatorioF(RelatorioF relatorioF) {
        this.relatorioF = relatorioF;
    }

    public List<RelatorioF> getListRelatorioF() {
        return listRelatorioF;
    }

    public void setListRelatorioF(List<RelatorioF> listRelatorioF) {
        this.listRelatorioF = listRelatorioF;
    }

    public String getTipoPesquisaRelatorioF() {
        return tipoPesquisaRelatorioF;
    }

    public void setTipoPesquisaRelatorioF(String tipoPesquisaRelatorioF) {
        this.tipoPesquisaRelatorioF = tipoPesquisaRelatorioF;
    }

    public String getTextoPesquisaRelatorioF() {
        return textoPesquisaRelatorioF;
    }

    public void setTextoPesquisaRelatorioF(String textoPesquisaRelatorioF) {
        this.textoPesquisaRelatorioF = textoPesquisaRelatorioF;
    }
    
    
}
