package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.controller.FuncionarioList;
import com.ufpa.scontroleportaria.tools.Security;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private Funcionario selecionadoEditfuncionario;
    private Funcionario selecionadoExcluirfuncionario;
    private Funcionario selecionadofuncionario;
    private FuncionarioList objListFuncionario;
    private List<Funcionario> listaFuncionario;
    private List<Funcionario> listaPDFFuncionario = new ArrayList<Funcionario>();
    private List<Funcionario> funcionarioSelect;

    @PostConstruct
    public void inicioFuncionario() {
        listarTodosFuncionarios();
    }

    public void cadastrarFuncionario() {
        try {
            funcionario.setSenhaFuncionario(security().encrypter(funcionario.getSenhaFuncionario()));
            getDaoGenerico().save(funcionario);
            getObjMessage().info("Cadastro efetuado!", "Funcionario cadastrado com sucesso");
        } catch (Exception e) {
            getObjMessage().warn("Cadastro não efetuado!", "O cadastro não foi realizado");
        }

    }

    public void editarFuncionario() {
        try {
            getDaoGenerico().update(selecionadoEditfuncionario);
            getObjMessage().info("Funcionário Atualizado!", "Com sucesso!");
            listarTodosFuncionarios();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Atualização Efetuada!", "Erro na atualização!");
        }

    }

    public void deletarFuncionario() {
        try {
            getDaoGenerico().remove(selecionadoExcluirfuncionario);
            getObjMessage().info("Funcionário Excluído!", "Com sucesso!");
            listarTodosFuncionarios();
        } catch (Exception e) {
            getObjMessage().warn("ERRO na Exclusão Efetuada!", "Erro na Exclusão!");
        }

    }

    public void listarTodosFuncionarios() {
        try {
            listaFuncionario = getDaoGenerico().list("SELECT f FROM Funcionario f");
            getObjMessage().info("Exibindo Funcionários", "Todas os Funcionários estão sendo listados!");
        } catch (Exception e) {
            getObjMessage().warn("Lista Inexistente", "Adicione Itens realizando um Novo Cadastro");
        }

    }

    private Security security() {
        return new Security();
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

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public List<Funcionario> getListaPDFFuncionario() {
        return listaPDFFuncionario;
    }

    public void setListaPDFFuncionario(List<Funcionario> listaPDFFuncionario) {
        this.listaPDFFuncionario = listaPDFFuncionario;
    }

    public Funcionario getSelecionadoEditfuncionario() {
        return selecionadoEditfuncionario;
    }

    public void setSelecionadoEditfuncionario(Funcionario selecionadoEditfuncionario) {
        this.selecionadoEditfuncionario = selecionadoEditfuncionario;
    }

    public Funcionario getSelecionadoExcluirfuncionario() {
        return selecionadoExcluirfuncionario;
    }

    public void setSelecionadoExcluirfuncionario(Funcionario selecionadoExcluirfuncionario) {
        this.selecionadoExcluirfuncionario = selecionadoExcluirfuncionario;
    }

    public Funcionario getSelecionadofuncionario() {
        return selecionadofuncionario;
    }

    public void setSelecionadofuncionario(Funcionario selecionadofuncionario) {
        this.selecionadofuncionario = selecionadofuncionario;
    }

    public List<Funcionario> getFuncionarioSelect() {
        if (this.funcionarioSelect == null){
            funcionarioSelect = (List<Funcionario>)getDaoGenerico().list("SELECT f FROM Funcionario f WHERE f.tipoFuncionario = 'Professor'");
        }
        return funcionarioSelect;
    }

    public void setFuncionarioSelect(List<Funcionario> funcionarioSelect) {
        this.funcionarioSelect = funcionarioSelect;
    }

}

/*

    public List<Object> getFuncionarioSelect() {
        if (this.funcionarioSelect == null) {
            funcionarioSelect = (List<Object>)getDaoGenerico().list("SELECT f, r FROM Funcionario f, Professor r where f.tipoFuncionario = 'Professor'");
            List<Funcionario> teste = (List<Funcionario>)funcionarioSelect.get(0);
            List<Professor> teste2 = (List<Professor>)funcionarioSelect.get(0);
            System.out.println("pk f "+teste.get(0).getPkFuncionario());
            System.out.println("pk r "+teste2.get(0).getPkProfessor());
            funcionarioSelect = null;
        }

        if (this.funcionarioSelect == null) {
            funcionarioSelect = new ArrayList<SelectItem>();
            List<Funcionario> listafunc = getDaoGenerico().list("SELECT f FROM Funcionario f where f.tipoFuncionario = 'Professor'");
            if (listafunc != null && !listafunc.isEmpty()) {
                SelectItem item = new SelectItem();
                for (Funcionario funcionarioLista : listafunc) {
                    item.setValue(funcionarioLista);
                    item.setLabel(funcionarioLista.getNomeFuncionario());
                    funcionarioSelect.add(item);

                }
            }



            professorSelect = new ArrayList<SelectItem>();
            List<Professor> listaprof = getDaoGenerico().list("SELECT r FROM Professor r");
            if (listaprof != null && !listaprof.isEmpty()) {
                SelectItem item = new SelectItem();
                for (Professor professorLista : listaprof) {
                    item.setValue(professorLista.getPkProfessor());
                  
                    professorSelect.add(item);

                }
            }



    public List<?> getProfessorSelect() {
        
            professorSelect = getDaoGenerico().list("SELECT f.nomeFuncionario, r.pkProfessor "
                    + "FROM Funcionario f, Professor r "
                    + "WHERE f.id.pkFuncionario = r.funcionario");
            List<CollectionClasses> retornaProfessor = new ArrayList<>();
            for (Object[] obj : (List<Object[]>) professorSelect) {
                CollectionClasses select = new CollectionClasses();

                select.getFuncionario().setNomeFuncionario((String) obj[0]);
                select.getProfessor().setPkProfessor((int) obj[1]);
                retornaProfessor.add(select);
                System.out.println(retornaProfessor);
                return retornaProfessor;
            }
        return retornaProfessor;
     
    }

 */