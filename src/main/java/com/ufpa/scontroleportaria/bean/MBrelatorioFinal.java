/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.controller.RelatorioFList;
import com.ufpa.scontroleportaria.model.RelatorioF;
import com.ufpa.scontroleportaria.relatorio.RelatorioFinalGerarPDF;
import java.util.ArrayList;
import java.util.List;
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
    private List<RelatorioF> listaRFPDF = new ArrayList<RelatorioF>();
    
    public void cadastrarRelatorioF() {
        try {
            getDaoGenerico().save(relatorioF);
            getObjMessage().info("Cadastro efetuado!", "Relatório Final cadastrado com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
        
    }
    
    
            public void listarTodosRelatoriosFinais(){
        try{
            listaRFPDF = getDaoGenerico().list("SELECT r FROM RelatorioF r");
            getObjMessage().info("Exibindo Relatórios Finais", "Todas os Relatórios Finais estão sendo listados!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }
        
    }
    
    public void gerarPDFRelatorioFinal() {
        RelatorioFinalGerarPDF relatoriof = new RelatorioFinalGerarPDF();
        relatoriof.getRelatorio(listaRFPDF);
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

    public List<RelatorioF> getListaRFPDF() {
        return listaRFPDF;
    }

    public void setListaRFPDF(List<RelatorioF> listaRFPDF) {
        this.listaRFPDF = listaRFPDF;
    }
    
    
}

    