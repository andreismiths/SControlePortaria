package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.controller.PortariaList;
import com.ufpa.scontroleportaria.controller.VariaveisDeSessao;
import com.ufpa.scontroleportaria.model.PortariaId;
import com.ufpa.scontroleportaria.relatorio.GerarPDFPortaria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private Portaria selecionadaEditPortaria;
    private Portaria selecionadaExcluirPortaria;
    private Portaria selecionadaPortaria;
    private Portaria selecionadaVisualizaPortaria;
    private PortariaList objListPortaria;
    private List<Portaria> listaPortaria;
    private List<Portaria> listaPortariaDeFuncionario;
    private List<Portaria> listaDialogPortaria = new ArrayList<Portaria>();
    private VariaveisDeSessao variaveisdesessao;

    @PostConstruct
    public void inicio() {
        listarTodasPortarias();
        listarPortariaDeFuncionario();
    }

    public void cadastrarPortaria() {
        try {
            PortariaId portariaid = new PortariaId();
            System.out.println(portaria.getFuncionario());
            portariaid.setFkFuncionario(portaria.getFuncionario().getPkFuncionario());
            portaria.setProfessorCoordenador(portaria.getFuncionario().getNomeFuncionario());
            portaria.setSiapeCoordenador(portaria.getFuncionario().getSiapeFuncionario());
            portaria.setId(portariaid);
            getDaoGenerico().save(portaria);
            getObjMessage().info("Cadastro efetuado!", "Portaria cadastrada com sucesso!");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void editarPortaria() {
        try {
            getDaoGenerico().update(selecionadaEditPortaria);
            getObjMessage().info("Portaria Atualizada!", "Com sucesso!");
            listarTodasPortarias();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Atualização Efetuada!", "Erro na atualização!");
        }

    }

    public void deletarPortaria() {
        try {
            getDaoGenerico().remove(selecionadaExcluirPortaria);
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

    public void listarPortariaDeFuncionario() {
        try {
            listaPortariaDeFuncionario = getDaoGenerico().list("select DISTINCT p FROM Portaria p, Funcionario f "
                    + "WHERE f.tipoFuncionario = 'Professor' "
                    + "AND " + getVariaveisdesessao().getPKFuncionario() + " = p.id.fkFuncionario");
            getObjMessage().info("Exibindo Portarias", "Todas as Suas Portarias estão sendo listadas!");
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
        GerarPDFPortaria gerarPDFPortaria = new GerarPDFPortaria();
        List<Portaria> item = new ArrayList<>();
        item.add(selecionadaPortaria);
        gerarPDFPortaria.getRelatorioUmaLinha(item);

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

    public Portaria getSelecionadaEditPortaria() {
        return selecionadaEditPortaria;
    }

    public void setSelecionadaEditPortaria(Portaria selecionadaEditPortaria) {
        this.selecionadaEditPortaria = selecionadaEditPortaria;
    }

    public Portaria getSelecionadaExcluirPortaria() {
        return selecionadaExcluirPortaria;
    }

    public void setSelecionadaExcluirPortaria(Portaria selecionadaExcluirPortaria) {
        this.selecionadaExcluirPortaria = selecionadaExcluirPortaria;
    }

    public List<Portaria> getListaPortariaDeFuncionario() {
        return listaPortariaDeFuncionario;
    }

    public void setListaPortariaDeFuncionario(List<Portaria> listaPortariaDeFuncionario) {
        this.listaPortariaDeFuncionario = listaPortariaDeFuncionario;
    }

    public VariaveisDeSessao getVariaveisdesessao() {
        return new VariaveisDeSessao();
    }

    public void setVariaveisdesessao(VariaveisDeSessao variaveisdesessao) {
        this.variaveisdesessao = variaveisdesessao;
    }

    public Portaria getSelecionadaVisualizaPortaria() {
        return selecionadaVisualizaPortaria;
    }

    public void setSelecionadaVisualizaPortaria(Portaria selecionadaVisualizaPortaria) {
        this.selecionadaVisualizaPortaria = selecionadaVisualizaPortaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.portaria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MBportaria other = (MBportaria) obj;
        if (!Objects.equals(this.portaria, other.portaria)) {
            return false;
        }
        return true;
    }
    
    

}
