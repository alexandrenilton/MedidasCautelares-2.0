/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agilles.medidascautelares.utils;

import br.com.agilles.medidascautelares.usuario.Usuario;
import java.util.Properties;
import javax.enterprise.event.Observes;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jille
 */
public class NotificacaoUtil {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public void enviarEmailRegistro(@Observes Usuario usuario) throws AddressException, MessagingException {
        //Passo 1 - Configurango propriedades do servidor de email - GMAIL
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        //Passo 2 - Pegando a sessão de Email
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getEmail()));
        generateMailMessage.setSubject("Conclua seu registro no sistema de Medidas Cautelares");
        String corpoEmail = "Seja bem vindo ao Sistema de Medidas Cautelares Sr(a): <b>" + usuario.getNome() + ".</b> Para dar prosseguimento em seu registro, responda esse email com uma "
                + "cópia de sua Funcional, pode ser digitalizado ou uma foto, desde que completamente legível.  <br><br> Atenciosamente, <br>Guarda Civil Municipal de Limeira"
                + "<br /> Setor de Inteligência<br /> Para Maiores informações: (19)34510968"
                + "<br />";
        generateMailMessage.setContent(corpoEmail, "text/html");

        //Passo 3 - Encaminhar email
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "intel.limeira@gmail.com", "a1s2d3q1w2e3");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

}
