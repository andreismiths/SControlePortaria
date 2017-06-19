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
            listaPDFPortaria = getDaoGenerico().list("SELECT p FROM Portaria p");
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
    
//gera pdf de uma portaria apenas, uma unica linha
    public void imprimirUnicoItem() {
        System.out.println("1111111111");
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        System.out.println("2222222222");
        List<Portaria> item = new ArrayList<>();
        System.out.println("3333333333");
        item.add(portaria);
        System.out.println("4444444444");
        gerarPDFPortaria.getRelatorioUmaLinha(item);
        System.out.println("5555555555");
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
