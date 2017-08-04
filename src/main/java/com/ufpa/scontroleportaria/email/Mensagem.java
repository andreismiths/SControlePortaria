/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.email;

import com.ufpa.scontroleportaria.bean.AbstractBean;
import org.primefaces.model.UploadedFile;
import com.ufpa.scontroleportaria.controller.VariaveisDeSessao;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author andreismiths
 */
public class Mensagem extends AbstractBean {

    private String titulo;
    private String mensagem;
    private UploadedFile anexo;
    private String email;
    private VariaveisDeSessao variaveisdesessao;
    private String nomeUsuarioEmail;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String da = sdf.format(new Date());
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String hr = sdf1.format(new Date());

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        titulo = "Relatório enviado por "+getVariaveisdesessao().getUsername()+", na data de "+da+" as "+hr;
        return titulo;
    }

    public void setTitulo(String titulo) {
        titulo = getVariaveisdesessao().getUsername();
        this.titulo = titulo;
    }

    public UploadedFile getAnexo() {
        return anexo;
    }

    public void setAnexo(UploadedFile anexo) {
        this.anexo = anexo;
    }

    public String getEmail() {
        email = getVariaveisdesessao().getEmail();
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public VariaveisDeSessao getVariaveisdesessao() {
        return new VariaveisDeSessao();
    }

    public void setVariaveisdesessao(VariaveisDeSessao variaveisdesessao) {
        this.variaveisdesessao = variaveisdesessao;
    }

    public String getNomeUsuarioEmail() {
        nomeUsuarioEmail = getVariaveisdesessao().getUsername();
        return nomeUsuarioEmail;
    }

    public void setNomeUsuarioEmail(String nomeUsuarioEmail) {
        this.nomeUsuarioEmail = nomeUsuarioEmail;
    }

}