/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.model.Professor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBprofessor")
@ViewScoped
public class MBprofessor extends AbstractBean {

    private List<Object> professorSelect;

    public List<Object> getProfessorSelect() {
        if (this.professorSelect == null){
            professorSelect = (List<Object>)getDaoGenerico().list("");
        }
        return professorSelect;
    }

    public void setProfessorSelect(List<Object> professorSelect) {
        this.professorSelect = professorSelect;
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

*/