package com.impetus.ogos.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
/**
 *In this class there is one method which is sent the mail to user.
 */
@Component
public class SentMail {
	@Autowired
	private JavaMailSender sender;
	
	static final Logger LOGGER = Logger.getLogger(SentMail.class);
	/**
	 * @param userEmail It is the user Email
	 * @param text It is the message 
	 */
	public void mail(String userEmail, String text) {
		LOGGER.debug("Inside SentMail Class Inside mail Method");
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(userEmail);
			helper.setText(text);
			helper.setSubject("Mail From OGOS");
			LOGGER.debug("Customer Mail Information\n" + "User Email:" + userEmail + "Text:" + text);
		} catch (MessagingException e) {
			LOGGER.error("Error While Sending Mail" + e);

		}
		sender.send(message);
		LOGGER.debug("Mail Sent:" + message);
	}

}
