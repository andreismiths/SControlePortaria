/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.testeEmail;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author andreismiths
 */
public class EmailUtils {

    private static final String username = "scontroleportarias@gmail.com";
    private static final String password = "@55smiths";
    private static final String emailOrigem = "scontroleportarias@gmail.com";

    public static Email conectaEmail() throws EmailException {
        MultiPartEmail email = new MultiPartEmail();
        email.setDebug(true);
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setFrom(emailOrigem);
        email.getMailSession().getProperties().put("mail.smtp.auth", "true");
        email.getMailSession().getProperties().put("mail.debug", "true");
        email.getMailSession().getProperties().put("mail.smtp.port", "587");
        email.getMailSession().getProperties().put("mail.smtp.socketFactory.port", "587");
        email.getMailSession().getProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        email.getMailSession().getProperties().put("mail.smtp.socketFactory.fallback", "false");
        email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
        return email;
    }

    public static void enviaEmail(Mensagem mensagem) throws EmailException {
        try {
            //adiciona as caracteristicas do email que são repassadas pelo usuário
            MultiPartEmail email = new MultiPartEmail();
            email = (MultiPartEmail) conectaEmail();
            email.setSubject(mensagem.getTitulo());
            email.setMsg(mensagem.getMensagem());
            email.addTo(mensagem.getDestino());

            //
            InputStream is = new BufferedInputStream(mensagem.getAnexo().getInputstream());

            DataSource source = new ByteArrayDataSource(is, mensagem.getAnexo().getContentType());
            email.attach(source, mensagem.getAnexo().getFileName(), "Description of some file");

            //envia o email
            String resposta = email.send();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "E-mail enviado com sucesso para: " + mensagem.getDestino(), "Informação"));
        } catch (IOException ex) {
            Logger.getLogger(EmailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getEmailOrigem() {
        return emailOrigem;
    }

}

/*  public static void enviaEmail(Mensagem mensagem) throws EmailException {
        //adiciona as caracteristicas do email que são repassadas pelo usuário
        MultiPartEmail email = new MultiPartEmail();
        email = (MultiPartEmail) conectaEmail();
        email.setSubject(mensagem.getTitulo());
        email.setMsg(mensagem.getMensagem());
        email.addTo(mensagem.getDestino());

        //cria o anexo para o email junto com suas propriedades
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("/home/andreismiths/NetBeansProjects/SControlePortariaTCC/SControlePortaria/src/main/webapp/resources/arquivos/images/banner_controle_portarias.png");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("anexo");
        attachment.setName("anexo");
        email.attach(attachment);

        //envia o email
        String resposta = email.send();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "E-mail enviado com sucesso para: " + mensagem.getDestino(), "Informação"));
    }
 */

 /* email.attach(mensagem.getAnexoFile());*/
