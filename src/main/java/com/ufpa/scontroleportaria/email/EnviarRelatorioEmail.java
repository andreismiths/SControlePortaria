/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.email;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.*;

/**
 *
 * @author andreismiths
 */
public class EnviarRelatorioEmail {

    Email email;

    public EnviarRelatorioEmail() {
        email = new SimpleEmail();
        configure();
    }

    private void configure() {
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setDebug(true);
        email.setAuthentication("scontroleportaria@gmail.com", "@55smiths");
        email.setSSLOnConnect(true);
        
    }

    public void enviarEmail(String dePara, String assunto, String mensagem, String destino) {

        try {

            email.setFrom("dePara");
            email.setSubject("assunto");
            email.setMsg("mensagem");
            email.addTo("destino");
            email.addReplyTo(dePara);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EnviarRelatorioEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    
}
