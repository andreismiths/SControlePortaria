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
    private String tipoPesquisaFuncionario;
    private String textoPesquisaFuncionario;

    
    public void listFuncionario() {
        listFuncionario = getDaoGenerico().
                list("select f from Funcionario f where "
                        + "f." + tipoPesquisaFuncionario + " like '%" + textoPesquisaFuncionario + "%'");
        if (!listFuncionario.isEmpty()) {
            getObjMessage().warn("Item não encontrado!", "O funcionário não foi encontrado.");
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

    public String getTipoPesquisaFuncionario() {
        return tipoPesquisaFuncionario;
    }

    public void setTipoPesquisaFuncionario(String tipoPesquisaFuncionario) {
        this.tipoPesquisaFuncionario = tipoPesquisaFuncionario;
    }

    public String getTextoPesquisaFuncionario() {
        return textoPesquisaFuncionario;
    }

    public void setTextoPesquisaFuncionario(String textoPesquisaFuncionario) {
        this.textoPesquisaFuncionario = textoPesquisaFuncionario;
    }

}
