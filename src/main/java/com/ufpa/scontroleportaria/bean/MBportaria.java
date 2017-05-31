package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.controller.PortariaList;
import com.ufpa.scontroleportaria.relatorio.GerarPDFPortaria;
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
    private PortariaList objListPortaria;
    private List<Portaria> listaPDFPortaria = new ArrayList<Portaria>();
    
    @PostConstruct
    public void inicio(){
        listaPDFPortaria = getDaoGenerico().list("SELECT p FROM Portaria p");
    }
    
    public void cadastrarPortaria() {
        try {
            getDaoGenerico().save(portaria);
            getObjMessage().info("Cadastro efetuado!", "Portaria cadastrada com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
        
    }
    
    public void listarTodasPortarias(){
        try{
            listaPDFPortaria = getDaoGenerico().list("SELECT p FROM Portaria p");
            getObjMessage().info("Exibindo Portarias", "Todas as Portarias estão sendo listadas!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }
        
    }
    //gera pdf de todas as portarias do banco 
    //NECESSITA DO ARQUIVO COM A CONEXAO COM O BANCO
    public void gerarPDF(){
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        gerarPDFPortaria.getRelatorio(listaPDFPortaria);
    }
    
    
    public void imprimir(){
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        List<Portaria> item = new ArrayList<>();
        item.add(portaria);
        gerarPDFPortaria.getRelatorio(item);
    }

    public Portaria getPortaria() {
        if (portaria == null) {
            portaria = new Portaria();
        }
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

    public List<Portaria> getListaPDFPortaria() {
        return listaPDFPortaria;
    }

    public void setListaPDFPortaria(List<Portaria> listaPDFPortaria) {
        this.listaPDFPortaria = listaPDFPortaria;
    }

}
