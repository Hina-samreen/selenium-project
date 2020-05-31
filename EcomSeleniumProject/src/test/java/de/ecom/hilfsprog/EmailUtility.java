package de.ecom.hilfsprog;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import de.ecom.testbasis.TestBasis;

import java.util.*;

public class EmailUtility extends TestBasis {
	
	  static String SMTP_HOST_NAME = config.getProperty("smtpHostName");
	  static String SMTP_AUTH_USER = config.getProperty("smtpUserName");
	  static String SMTP_AUTH_PWD  = config.getProperty("smtpPassword");
	  static String emailMsgTxt      = config.getProperty("emailMessage");
	  static String emailSubjectTxt  = config.getProperty("emailSubject");
	  static String emailFromAddress = config.getProperty("emailFromAddress");
  

      // Add List of Email address to who email needs to be sent to
      private static final String[] emailList = {config.getProperty("emailToAddress1"),config.getProperty("emailToAddress2")};
      private static String sFilename = null;
      
	 
 public static void emailUtil(String vFilename) throws MessagingException
      {
	      
      // 6. Attach this exported file and email to another email id
	      sFilename = vFilename;
	      EmailUtility smtpMailSender = new EmailUtility();
    	  smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    	  
      }

  private BodyPart messageBodyPart;

  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    //boolean debug = false;
    //Set the host smtp address 
     Properties props = new Properties();
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     props.put("mail.smtp.prot", "465");
     props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props,auth);
    // session.setDebug(debug);
   
    // create a message
    Message msg = new MimeMessage(session);
    
    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);
      
    // new code added
    Multipart multipart = new MimeMultipart();
    // multipart.addBodyPart(messageBodyPart);
   
    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    String filename = sFilename;
    DataSource source = new FileDataSource(filename);
    messageBodyPart.setDataHandler(new DataHandler(source));
    
    messageBodyPart.setFileName(sFilename);
    messageBodyPart.setDescription(message);
    multipart.addBodyPart(messageBodyPart);
   
    // Put parts in message
    msg.setContent(multipart);
   
    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    
    msg.setRecipients(Message.RecipientType.TO, addressTo); 
    
  // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(multipart);
    Transport.send(msg);
      
 }

/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}

  

