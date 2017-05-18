/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.testeEmail;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author andreismiths
 */

public class EmailUtils {
     
 private static final String HOSTNAME = "smtp.gmail.com";
 private static final String USERNAME = "scontroleportarias@gmail.com";
 private static final String PASSWORD = "@55smiths";
 private static final String EMAILORIGEM = "scontroleportarias@gmail.com";
 
 public static Email conectaEmail() throws EmailException {
 Email email = new SimpleEmail();
 email.setDebug(true);
 email.setHostName(HOSTNAME);
 email.setSmtpPort(465);
 email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
 email.setSSLOnConnect(true);
 email.setTLS(true);
 email.setFrom(EMAILORIGEM);
 return email;
 }
 
 public static void enviaEmail(Mensagem mensagem) throws EmailException {
 Email email = new SimpleEmail();
 email = conectaEmail();
 email.setSubject(mensagem.getTitulo());
 email.setMsg(mensagem.getMensagem());
 email.addTo(mensagem.getDestino());
 String resposta = email.send();
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso para: " + mensagem.getDestino(), "Informação"));
 }
}
