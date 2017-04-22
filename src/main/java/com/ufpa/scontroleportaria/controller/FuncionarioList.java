/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.controller;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.bean.AbstractBean;
import java.util.List;

/**
 *
 * @author andreismiths
 */
public class FuncionarioList extends AbstractBean {
    
    private Funcionario funcionario;
    private List<Funcionario> listFuncionario;
    private String tipoPesquisa;
    private String textoPesquisa;

    
    public void listPortaria() {
        listFuncionario = getDaoGenerico().
                list("select c from Cidade c where "
                        + "c." + tipoPesquisa + " like '%" + textoPesquisa + "%'");
        if (!listFuncionario.isEmpty()) {
            getObjMessage().warn("Item não encontrado!", "A cidade não foi encontrada.");
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListFuncionario() {
        return listFuncionario;
    }

    public void setListFuncionario(List<Funcionario> listFuncionario) {
        this.listFuncionario = listFuncionario;
    }

    public String getTipoPesquisa() {
        return tipoPesquisa;
    }

    public void setTipoPesquisa(String tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }

    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
    }
    
    
}
