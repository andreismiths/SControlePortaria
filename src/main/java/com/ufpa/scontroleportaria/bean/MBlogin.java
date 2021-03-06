/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import com.ufpa.scontroleportaria.DAO.SessionUtils;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.ufpa.scontroleportaria.tools.Security;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBlogin")
@ViewScoped
public class MBlogin extends AbstractBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String siapeEmail;
    String senha;

    public String validateUserPassword() throws IOException {
        senha = new Security().encrypter(senha);
        int valid = getDaoGenerico().validate(siapeEmail, senha);
        if (valid != -1) {
            getVariaveisDeSessao().setDadosFuncionario((Object) getDaoGenerico().list("select f from Funcionario f where f.pkFuncionario=" + valid).get(0));
            if (getVariaveisDeSessao().getTipoFuncionario().equals("Professor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("PaginaInicialFuncionario.xhtml");
                System.out.println("BACK-END WARNING: USER LOGGED! username=" + getVariaveisDeSessao().getUsername());
                System.out.println("BACK-END WARNING: USER LOGGED! email=" + getVariaveisDeSessao().getEmail());
                System.out.println("BACK-END WARNING: USER LOGGED! tipo=" + getVariaveisDeSessao().getTipoFuncionario());
                System.out.println("BACK-END WARNING: USER LOGGED! PK=" + getVariaveisDeSessao().getPKFuncionario());
                return "PaginaInicialFuncionario";
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("PaginaInicial.xhtml");
                System.out.println("BACK-END WARNING: USER LOGGED! username=" + getVariaveisDeSessao().getUsername());
                return "PaginaInicial";
            }
        } 
        else {
            getObjMessage().warn("Nome de Usuário ou Senha incorretos!", "Por favor, insira os dados corretamente!");
            System.out.println("BACK-END WARNING: USER NOT LOGGED! [ public String validateUsernamePassword() throws IOException ]");
            return "Login";
        }
    }

    //logout event, invalidate session
    public void logout() throws IOException {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        System.out.println("BACK-END WARNING: SESSION INVALIDATED!");
    }

    public String goToLogin() {
        return "Login";
    }

    public String getSiapeEmail() {
        return siapeEmail;
    }

    public void setSiapeEmail(String siapeEmail) {
        this.siapeEmail = siapeEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
