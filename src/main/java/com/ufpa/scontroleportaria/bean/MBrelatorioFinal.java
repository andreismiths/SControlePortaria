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
import javax.annotation.PostConstruct;
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
    private RelatorioF selecionadoRelatorioF;
    private RelatorioF selecionadoExcluirRelatorioF;
    private RelatorioF selecionadoEditRelatorioF;
    private RelatorioFList objListRelatorioF;
    private List<RelatorioF> listaRelatorioF;
    private List<RelatorioF> listaRFPDF = new ArrayList<RelatorioF>();
    
    
   @PostConstruct
   public void inicioRelatorioF(){
       listarTodosRelatoriosFinais();
   }
    public void cadastrarRelatorioF() {
        try {
            getDaoGenerico().save(relatorioF);
            getObjMessage().info("Cadastro efetuado!", "Relatório Final cadastrado com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
        
    }
      public void editarRelatorioF() {
        try {
                getDaoGenerico().update(selecionadoEditRelatorioF);
            getObjMessage().info("Relatório Final Atualizado!", "Com sucesso!");
            listarTodosRelatoriosFinais();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Atualização Efetuada!", "Erro na atualização!");
        }

    }
          public void deletarRelatorioF() {
        try {
            getDaoGenerico().remove(selecionadoExcluirRelatorioF);
            getObjMessage().info("Relatório Final Excluído!", "Com sucesso!");
            listarTodosRelatoriosFinais();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Exclusão Efetuada!", "Erro na Exclusão!");
        }

    }
    
            public void listarTodosRelatoriosFinais(){
        try{
            listaRelatorioF = getDaoGenerico().list("SELECT r FROM RelatorioF r");
            getObjMessage().info("Exibindo Relatórios Finais", "Todas os Relatórios Finais estão sendo listados!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }
        
    }
    
    public void pdfTodosRelatorioFinal() {
        RelatorioFinalGerarPDF relatoriof = new RelatorioFinalGerarPDF();
        relatoriof.getTodosRelatorio();
}
    public void pdfUmRelatorioFinal(){
        RelatorioFinalGerarPDF relatoriof = new RelatorioFinalGerarPDF();
        List<RelatorioF> item = new ArrayList<>();
        item.add(selecionadoRelatorioF);
        relatoriof.getUmRelatorio(item);
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

    public List<RelatorioF> getListaRelatorioF() {
        return listaRelatorioF;
    }

    public void setListaRelatorioF(List<RelatorioF> listaRelatorioF) {
        this.listaRelatorioF = listaRelatorioF;
    }

    public List<RelatorioF> getListaRFPDF() {
        return listaRFPDF;
    }

    public void setListaRFPDF(List<RelatorioF> listaRFPDF) {
        this.listaRFPDF = listaRFPDF;
    }

    public RelatorioF getSelecionadoRelatorioF() {
        return selecionadoRelatorioF;
    }

    public void setSelecionadoRelatorioF(RelatorioF selecionadoRelatorioF) {
        this.selecionadoRelatorioF = selecionadoRelatorioF;
    }

    public RelatorioF getSelecionadoExcluirRelatorioF() {
        return selecionadoExcluirRelatorioF;
    }

    public void setSelecionadoExcluirRelatorioF(RelatorioF selecionadoExcluirRelatorioF) {
        this.selecionadoExcluirRelatorioF = selecionadoExcluirRelatorioF;
    }

    public RelatorioF getSelecionadoEditRelatorioF() {
        return selecionadoEditRelatorioF;
    }

    public void setSelecionadoEditRelatorioF(RelatorioF selecionadoEditRelatorioF) {
        this.selecionadoEditRelatorioF = selecionadoEditRelatorioF;
    }
    
}

    