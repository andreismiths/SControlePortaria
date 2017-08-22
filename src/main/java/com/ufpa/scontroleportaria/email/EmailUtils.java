/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.email;

import com.ufpa.scontroleportaria.bean.AbstractBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author andreismiths
 */
public class EmailUtils extends AbstractBean {

    private static final String username = "scontroleportarias@gmail.com";
    private static final String password = "@scontroleufpafacomp";
 
    public static Email conectaEmail(Mensagem mensagem) throws EmailException {
        MultiPartEmail email = new MultiPartEmail();
        email.setDebug(true);
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setFrom(mensagem.getEmail());
        email.getMailSession().getProperties().put("mail.smtp.auth", "true");
        email.getMailSession().getProperties().put("mail.debug", "true");
        email.getMailSession().getProperties().put("mail.smtp.port", "587");
        email.getMailSession().getProperties().put("mail.smtp.socketFactory.port", "587");
      // essa propriedade no tomcat n tava fazendo funcionar
        //  email.getMailSession().getProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        email.getMailSession().getProperties().put("mail.smtp.socketFactory.fallback", "false");
        email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
        return email;
    }

    public static void enviaEmail(Mensagem mensagem) throws EmailException, IOException, Exception {
        //adiciona as caracteristicas do email que são repassadas pelo usuário
        MultiPartEmail email = new MultiPartEmail();
        email = (MultiPartEmail) conectaEmail(mensagem);

        if (mensagem.getAnexo() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "O anexo está vazio.", "Informação"));
        } else {
            email.setSubject(mensagem.getTitulo());
            email.setMsg(mensagem.getMensagem());
            email.addTo("scontroleportarias@gmail.com");

            // attachment
            @SuppressWarnings("deprecation")
			ByteArrayDataSource source = new ByteArrayDataSource(mensagem.getAnexo().getInputstream(), mensagem.getAnexo().getContentType());
            email.attach(source, mensagem.getAnexo().getFileName(), "");
            String resposta = email.send();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    mensagem.getNomeUsuarioEmail()+" o seu Relatório foi enviado com sucesso!", "Informação"));
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

}
