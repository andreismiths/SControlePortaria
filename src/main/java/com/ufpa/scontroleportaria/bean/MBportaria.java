package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.controller.PortariaList;
import com.ufpa.scontroleportaria.relatorio.GerarPDFPortaria;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBportaria")
@ViewScoped
public class MBportaria extends AbstractBean {

    private Portaria portaria;
    private PortariaList objListPortaria;
    private List<Portaria> listaPDFPortaria = new ArrayList<Portaria>();
    
    
    public void cadastrarPortaria() {
        try {
            getDaoGenerico().save(portaria);
            getObjMessage().info("Cadastro efetuado!", "Portaria cadastrada com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }
        
    }
    
    public void listarPortaria(){
        try{
            listaPDFPortaria = getDaoGenerico().list(portaria);
            getObjMessage().info("Exibindo Portarias", "Todas as Portarias estão sendo listadas!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }
        
    }
    
    public void gerarPDF(){
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        gerarPDFPortaria.getRelatorio(listaPDFPortaria);
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
