package com.impetus.ogos.util;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.rest.CustomerFeedbackController;
/**
 *In this class define the one scheduler method.
 *
 */
@Component
@RequestMapping("schedular")
@Transactional
public class SchedulingClass {

	static final Logger LOGGER = Logger.getLogger(SchedulingClass.class);
	static final int NUM = -5;
	static final int ZERO = 0;
	static final int ONE = 1;
	static final int TWO = 2;
	static final int THREE = 3;
	static final int TWENTYFOUR =24;
	static final int THOUSAND = 1000;
	static final int SIXTY = 60;
	@Autowired
	private SentMail sentMail;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private CustomerFeedbackController customerFeedbackController;
	/**It is calling the sentMail method every 6 hours.
	 * @throws ResourceNotFound If customer list not found.
	 */
	@Scheduled(cron = "0 0/1 * 1/1 * ? ")
	public void sentMail() throws ResourceNotFound {
		LOGGER.debug("Inside SchedulingClass Class Inside sentMail Method");
		List<String> list = customerFeedbackController.getUserId();
		String text = "Give The Feedback";

		// get the details of user

		for (Object objects : list) {
			Object[] userInfo = (Object[]) objects;
			String userId = userInfo[TWO].toString();
			int customerRating = Integer.parseInt(userInfo[THREE].toString());
			LOGGER.debug("User Id:" + userId + "User Rating:" + customerRating);
			Date creationTime = (Date) userInfo[1];
			Date currentTime = new Date();
			long diff = currentTime.getTime() - creationTime.getTime();
			long diffHours = diff / (SIXTY * SIXTY * THOUSAND) % TWENTYFOUR;
			LOGGER.info("	Creation Time of feedback Table:" + creationTime + "Current Time:" + currentTime
					+ "DiffHours:" + diffHours);

			// if current time and creation time equal means Not 24 Hours,then sent feedback
			// reminder mail to Customer

			if (currentTime.getDate() == creationTime.getDate()) {
				LOGGER.debug("User Email" + userInfo[ZERO] + "Test" + text);
				sentMail.mail(userInfo[ZERO].toString(), text);
				LOGGER.debug("Mail Sent!!");
			} else if (diff >= ZERO) { // if both time difference greater then zero then check the customer Rating

				// if ratinng greater than -5,then add -1

				if (customerRating >NUM) {
					LOGGER.debug("Customer Rating:" + customerRating);
					customerRating=customerRating-1;
					Query query = entityManager
							.createNativeQuery("update user set customer_rating=:customerRating where user_id=:userId");
					query.setParameter("userId", userId);
					query.setParameter("customerRating", customerRating);
                    
					LOGGER.info("Update Row:" + query.executeUpdate());
				} else { // else update active status false
					Query query = entityManager.createNativeQuery("update user set isactive=0 where user_id=:userId");
					query.setParameter("userId", userId);
					LOGGER.info("Updated Row:" + query.executeUpdate());
				}
			} else { // if both time difference not greater then zero then sent the mail
				sentMail.mail(userInfo[ZERO].toString(), text);
				LOGGER.debug("Mail Sent!");
			}
		}
	}

}
