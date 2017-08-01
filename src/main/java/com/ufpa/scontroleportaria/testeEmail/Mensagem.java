/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.testeEmail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author andreismiths
 */
public class Mensagem {

    private String destino;
    private String titulo;
    private String mensagem;
    private UploadedFile anexo;
    private File anexoFile;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UploadedFile getAnexo() {
        
        return anexo;
    }

    public void setAnexo(UploadedFile anexo) {
        this.anexo = anexo;
    }

    public File getAnexoFile() {
        return anexoFile;
    }

    public void setAnexoFile(File anexoFile) {
        this.anexoFile = anexoFile;
    }

}
