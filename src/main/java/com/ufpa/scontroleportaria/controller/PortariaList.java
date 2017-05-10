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
    private String tipoPesquisaPortaria;
    private String textoPesquisaPortaria;

    
    public void listPortaria() {
        listPortaria = getDaoGenerico().
                list("select p from Portaria p where "
                        + "p." + tipoPesquisaPortaria + " like '%" + textoPesquisaPortaria + "%'");
        if (!listPortaria.isEmpty()) {
            getObjMessage().warn("Item não encontrado!", "A portaria não foi encontrada.");
        }
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

    public String getTipoPesquisaPortaria() {
        return tipoPesquisaPortaria;
    }

    public void setTipoPesquisaPortaria(String tipoPesquisaPortaria) {
        this.tipoPesquisaPortaria = tipoPesquisaPortaria;
    }

    public String getTextoPesquisaPortaria() {
        return textoPesquisaPortaria;
    }

    public void setTextoPesquisaPortaria(String textoPesquisaPortaria) {
        this.textoPesquisaPortaria = textoPesquisaPortaria;
    }

}
