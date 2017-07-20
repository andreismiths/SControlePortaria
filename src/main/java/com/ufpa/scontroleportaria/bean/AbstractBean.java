/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.DAO.GenericoDAO;
import com.ufpa.scontroleportaria.DAO.GenericoDAOImpl;
import com.ufpa.scontroleportaria.controller.Tools;
import com.ufpa.scontroleportaria.controller.VariaveisDeSessao;
import com.ufpa.scontroleportaria.tools.FacesMessages;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author andreismiths
 */
public abstract class AbstractBean implements Serializable {

    private GenericoDAO daoGenerico;

    public GenericoDAO getDaoGenerico() {
        if (daoGenerico == null) {
            daoGenerico = new GenericoDAOImpl();
        }
        return daoGenerico;
    }

    private FacesMessages message;

    public FacesMessages getObjMessage() {
        if (message == null) {
            message = new FacesMessages();
        }
        return message;
    }

        private Tools tools;

    public Tools getObjTools() {
        if (tools == null) {
            tools = new Tools();
        }
        return tools;
    }
    
    private Date data;

    public Date getObjData() {
        if (data == null) {
            data = new Date();
        }
        return data;
    }
    
    private VariaveisDeSessao variaveisDeSessao;
    
    public VariaveisDeSessao getVariaveisDeSessao () {
        if (variaveisDeSessao == null) {
            variaveisDeSessao = new VariaveisDeSessao();
        }
        return variaveisDeSessao;
    }
}
