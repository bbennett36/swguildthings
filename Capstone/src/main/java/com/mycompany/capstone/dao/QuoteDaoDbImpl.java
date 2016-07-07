/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.dao;

import com.mycompany.capstone.dto.Quote;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 *
 * @author apprentice
 */
public class QuoteDaoDbImpl implements QuoteDao {

    private static final String SQL_INSERT_QUOTE = "insert into quotes (first_name, last_name, email, year, make, model, service_comments) values (?,?,?,?,?,?,?)";

    private JdbcTemplate jdbcTemplate;
    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public QuoteDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @Override
    public Quote create(Quote quote) {

        jdbcTemplate.update(SQL_INSERT_QUOTE,
                quote.getFirstName(),
                quote.getLastName(),
                quote.getEmail(),
                quote.getYear(),
                quote.getSelectedMake(),
                quote.getSelectedModel(),
                quote.getDescription());

        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        quote.setId(id);

        Properties props = (Properties) System.getProperties().clone();
        props.put("mail.smtp.host", "host");
        props.setProperty("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);

//Bypass the SSL authentication
        props.put("mail.smtp.ssl.enable", false);
        props.put("mail.smtp.starttls.enable", false);

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo("bennettglob@gmail.com");
//        msg.setRecipients(Message.RecipientType.TO, ("bennettglob@gmail.com" + quote.getEmail()));

        msg.setText(
                "test");
        try {
            this.mailSender.send(msg);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }

        return quote;

    }

}
