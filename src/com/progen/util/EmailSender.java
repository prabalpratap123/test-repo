package com.progen.util;


	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.Multipart;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.AddressException;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeBodyPart;
	import javax.mail.internet.MimeMessage;
	import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

	public class EmailSender {


	    public static void setAddress() {
	        // SMTP info
	        String host = "smtp.gmail.com";
	        String port = "587";
	        String mailFrom = "ppsingh.singh2@gmail.com";
	        String password = "9026035533p";

	        // message info
	        String[] mailTo = {"prabalpratap191@gmail.com","prabal.singh@progenbusiness.com","ppsingh.singh2@gmail.com","yes.rathaur1990@gmail.com","pankaj.baderia@progenbusiness.com"};
	       //Mail id you want to send;

	        String subject = "Daily Task Status";
	        String message = "Daily Task Status, I have some attachments for you.";

	        // attachments
	        String[] attachFiles = new String[1];

	        attachFiles[0] = File.separator+"usr/local/cache/status/ProgenStatus"+ExcelCreator.getCurrentDateAndMonth()+".xlsx";

	        try {
	            sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message, attachFiles);
	            System.out.println("Email sent.");
	        } catch (Exception ex) {
	            System.out.println("Could not send email.");
	            ex.printStackTrace();
	        }
	    }




	    public static void sendEmailWithAttachments(String host, String port,
	            final String userName, final String password, String[] toAddress,
	            String subject, String message, String[] attachFiles)
	            throws AddressException, MessagingException, IOException {
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.user", userName);
	        properties.put("mail.password", password);

	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);

	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);

	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] address = new InternetAddress[toAddress.length];
	        for(int i =0; i< toAddress.length; i++)
	        {
	            address[i] = new InternetAddress(toAddress[i]);
	        }
//	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, address);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());


	        // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html");

	        // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);

	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();

	                try {
	                    attachPart.attachFile(filePath);
//	                    attachPart.attachFile(f);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }

	                multipart.addBodyPart(attachPart);
	            }
	        }

	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);

	        // sends the e-mail
	        Transport.send(msg);

	    }






	    /**
	     * Test sending e-mail with attachments
	     */
//	    public static void main(String[] args) {
//	        // SMTP info
//	        String host = "smtp.gmail.com";
//	        String port = "587";
//	        String mailFrom = "ppsingh.singh2@gmail.com";
//	        String password = "9026035533p";
//
//	        // message info
//	        String[] mailTo = {"prabalpratap191@gmail.com","prabal.singh@progenbusiness.com","ppsingh.singh2@gmail.com","yes.rathaur1990@gmail.com"};
//	       //Mail id you want to send;
//
//	        String subject = "Daily Task Status";
//	        String message = "Daily Task Status, I have some attachments for you.";
//	        Calendar cal = Calendar.getInstance();
//			 String month = cal.DATE+"-"+cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
//
//	        // attachments
//	        String[] attachFiles = new String[1];
//	        attachFiles[0] = "//usr/local/cache/status/ProgenStatus"+ExcelCreator.getCurrentDateAndMonth()+".xlsx";
//
//	        try {
//	            sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message, attachFiles);
//	            System.out.println("Email sent.");
//	        } catch (Exception ex) {
//	            System.out.println("Could not send email.");
//	            ex.printStackTrace();
//	        }
//	    }



	}

