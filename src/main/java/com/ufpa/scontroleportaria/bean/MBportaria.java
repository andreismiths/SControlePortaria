package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.controller.PortariaList;
import com.ufpa.scontroleportaria.relatorio.GerarPDFPortaria;
import com.ufpa.scontroleportaria.relatorio.PdfTodasPortarias;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBportaria")
@ViewScoped
public class MBportaria extends AbstractBean implements Serializable {
       
    private Portaria portaria;
    private Portaria selecionadaPortaria;
    private PortariaList objListPortaria;
    private List<Portaria> listaPortaria;
    private List<Portaria> listaDialogPortaria = new ArrayList<Portaria>();
    
    @PostConstruct
    public void inicio(){
        listarTodasPortarias();
    }

    public void cadastrarPortaria() {
        try {
            getDaoGenerico().save(portaria);
            getObjMessage().info("Cadastro efetuado!", "Portaria cadastrada com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void editarPortaria() {
        try {
            getDaoGenerico().update(portaria);
            getObjMessage().info("Portaria Atualizada!", "Com sucesso!");
            listarTodasPortarias();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Atualização Efetuada!", "Erro na atualização!");
        }

    }

    public void deletarPortaria() {
        try {
            getDaoGenerico().remove(portaria);
            getObjMessage().info("Portaria Excluída!", "Com sucesso!");
            listarTodasPortarias();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Exclusão Efetuada!", "Erro na Exclusão!");
        }

    }

    public void listarTodasPortarias() {
        try {
            listaPortaria = getDaoGenerico().list("SELECT p FROM Portaria p");
            getObjMessage().info("Exibindo Portarias", "Todas as Portarias estão sendo listadas!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }

    }
    //gera pdf de todas as portarias do banco 

    public void imprimirTodas() {
        GerarPDFPortaria gPDFPortaria = new GerarPDFPortaria();
        gPDFPortaria.getRelatorioTodas();
    }
    
    public void pdfTodas(){
        PdfTodasPortarias pdftodas = new PdfTodasPortarias();
        pdftodas.todasPortarias();
    }

//gera pdf de uma portaria apenas, uma unica linha
    public void imprimirUnicoItem() {
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        List<Portaria> item = new ArrayList<>();
        item.add(portaria);
        gerarPDFPortaria.getRelatorioUmaLinha(item);

    }

    public Portaria getPortaria() {
//        if (portaria == null) {
//            portaria = new Portaria();
//        }
        return portaria;
    }

    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }

    public PortariaList getObjListPortaria() {
        if (objListPortaria == null) {
            objListPortaria = new PortariaList();
        }
        return objListPortaria;
    }

    public List<Portaria> getListaPortaria() {
        return listaPortaria;
    }

    public void setListaPortaria(List<Portaria> listaPortaria) {
        this.listaPortaria = listaPortaria;
    }

    public List<Portaria> getListaDialogPortaria() {
        return listaDialogPortaria;
    }

    public void setListaDialogPortaria(List<Portaria> listaDialogPortaria) {
        this.listaDialogPortaria = listaDialogPortaria;
    }

    public Portaria getSelecionadaPortaria() {
        return selecionadaPortaria;
    }

    public void setSelecionadaPortaria(Portaria selecionadaPortaria) {
        this.selecionadaPortaria = selecionadaPortaria;
    }
    
    

}
