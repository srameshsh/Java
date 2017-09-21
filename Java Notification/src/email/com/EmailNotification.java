package email.com;
import java.util.Properties;

import javax.mail.*;    
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;  

/**
 * 
 */

/**
 * @author ramesh.s
 *
 */
public class EmailNotification {

	/**
	 * @param args
	 */
	final static String FROM_EMAIL = "FROM_EMAIL";
	final static String FROM_EMAIL_PASSWORD = "FROM_EMAIL_PASSWORD";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	EmailNotification email = new EmailNotification();
	
	email.sendingEmail(FROM_EMAIL, FROM_EMAIL_PASSWORD, "to email address", "INVITATION", "God is great!");
} catch (Exception e) {
	e.printStackTrace();
}
	}
	  public  void sendingEmail(String from,String password,String toemail,String sub,String msg){  
          //Get properties object    
          Properties email_properties = new Properties();    
          email_properties.put("mail.smtp.host", "smtp.gmail.com");    
          email_properties.put("mail.smtp.socketFactory.port", "465");    
          email_properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
          email_properties.put("mail.smtp.auth", "true");    
          email_properties.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(email_properties,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try { 
        	  
        	 
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
      
           
           message.setSubject(sub);    
          // message.setText(msg); 
           message.setContent("<h1>sending html mail check</h1>","text/html" );  
           //send message  
          
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {
        	  throw new RuntimeException(e);}    
             
    } 

}
