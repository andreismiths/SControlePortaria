package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.controller.FuncionarioList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBfuncionario")
@ViewScoped
public class MBfuncionario extends AbstractBean {

    private Funcionario funcionario;
    private FuncionarioList objListFuncionario;
    private List<Funcionario> listaPDFFuncionario = new ArrayList<Funcionario>();

    public void cadastrarFuncionario() {
        try {
            getDaoGenerico().save(funcionario);
            getObjMessage().info("Cadastro efetuado!", "Funcionario cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void editarFuncionario() {
        try {
            System.out.println("Entrou no try");
            getDaoGenerico().update(funcionario);
            getObjMessage().info("Funcionário Atualizado!", "Com sucesso!");
            listarTodosFuncionarios();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Atualização Efetuada!", "Erro na atualização!");
        }

    }

    public void deletarFuncionario() {
        try {
            getDaoGenerico().remove(funcionario);
            getObjMessage().info("Funcionário Excluído!", "Com sucesso!");
            listarTodosFuncionarios();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Exclusão Efetuada!", "Erro na Exclusão!");
        }

    }

    public void listarTodosFuncionarios() {
        try {
            listaPDFFuncionario = getDaoGenerico().list("SELECT f FROM Funcionario f");
            getObjMessage().info("Exibindo Funcionários", "Todas os Funcionários estão sendo listados!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }

    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioList getObjListFuncionario() {
        if (objListFuncionario == null) {
            objListFuncionario = new FuncionarioList();
        }
        return objListFuncionario;
    }

    public List<Funcionario> getListaPDFFuncionario() {
        return listaPDFFuncionario;
    }

    public void setListaPDFFuncionario(List<Funcionario> listaPDFFuncionario) {
        this.listaPDFFuncionario = listaPDFFuncionario;
    }

}
