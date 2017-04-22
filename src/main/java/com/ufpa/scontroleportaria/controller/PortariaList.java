package com.ufpa.scontroleportaria.controller;

import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.bean.AbstractBean;
import java.util.List;

/**
 *
 * @author andreismiths
 */
public class PortariaList extends AbstractBean {

    private Portaria portaria;
    private List<Portaria> listPortaria;
    private String tipoPesquisa;
    private String textoPesquisa;

    
    public void listPortaria() {
        listPortaria = getDaoGenerico().
                list("select c from Cidade c where "
                        + "c." + tipoPesquisa + " like '%" + textoPesquisa + "%'");
        if (!listPortaria.isEmpty()) {
            getObjMessage().warn("Item não encontrado!", "A cidade não foi encontrada.");
        }
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

    public Portaria getPortaria() {
        return portaria;
    }

    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }

    public List<Portaria> getListPortaria() {
        return listPortaria;
    }

    public void setListPortaria(List<Portaria> listPortaria) {
        this.listPortaria = listPortaria;
    }

}
