package tools;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import org.junit.Assert;

public class ReadMailSample {

	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	private String userName = "daniel.tise@evozon.com";// provide user name
	private String password = "Noaptebuna5.";// provide password


	public void compare(String sub, String cont, String subiect,String continut) throws Exception
	{

		//String newVacationReqSubject ="You have submitted a new Vacation Request";
		//String newVacationReqContent ="Dear Dani Tise,  You have submitted a new Vacation Request. The Vacation interval is: 07/10/2014 - 09/10/2014.  Sincerely,  EvoPortal Team";
		//String vacationReqWithdrawnSubject = "Vacation Request Withdrawn";
		//String withdrawnContent = "Dear Dani Tise, Your Vacation Request from 19/05/2014 until 19/05/2014 was withdrawn.  Sincerely,  EvoPortal Team";

		System.out.println("SUBJECT: " + sub);
		System.out.println("SUBJECT: " + subiect);
		System.out.println("BODY: " + cont);
		System.out.println("BODY: " + continut);

		Assert.assertTrue(cont.contains(continut)&&sub.contains(subiect)); 	
		//Assert.assertTrue(sub.contains(newVacationReqSubject));
		//assertThat(cont).isSameAs(newVacationReqContent);

//		System.out.println(cont);
//		System.out.println(continut);
//		System.out.println(sub);
//		System.out.println(subiect);

	}

	public void readMails(String subiect, String continut) throws Exception {
		properties = new Properties();
		properties.setProperty("mail.host", "mail.evozon.com");
		properties.setProperty("mail.port", "993");
		properties.setProperty("mail.transport.protocol", "imaps");
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		try {
			store = session.getStore("imaps");
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.search(new FlagTerm(
					new Flags(Flag.SEEN), false));
			;
			System.out.println("Number of mails = " + messages.length);

			Message message = messages[messages.length-1];
			Address[] from = message.getFrom();

			//                System.out.println("Date : " + message.getSentDate());            
			//                System.out.println("From : " + from[0]);
			//                System.out.println("Subject: " + message.getSubject());               
			//                System.out.println("Content :");
			processMessageBody(message);




			String subject = message.getSubject();
			String content = message.getContent().toString().replaceAll("\\<.*?>","");                 

			//}
			inbox.close(true);
			store.close(); 
			compare(subject, content , subiect , continut);



		} catch (NoSuchProviderException e) {
			e.printStackTrace();

		} catch (MessagingException e) {
			e.printStackTrace();
		}	  
	}


	public void processMessageBody(Message message) {
		try {
			Object content = message.getContent();
			// check for string
			// then check for multipart
			if (content instanceof String) {
				System.out.println(content);
			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					System.out.write(ch);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void procesMultiPart(Multipart content) {

		try {
			int multiPartCount = content.getCount();
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;

				o = bodyPart.getContent();
				if (o instanceof String) {
					System.out.println(o);
				} else if (o instanceof Multipart) {
					procesMultiPart((Multipart) o);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	//    public static void main(String[] args) throws Exception {
	//        ReadMailSample sample = new ReadMailSample();
	//        sample.readMails();
	//    }

}