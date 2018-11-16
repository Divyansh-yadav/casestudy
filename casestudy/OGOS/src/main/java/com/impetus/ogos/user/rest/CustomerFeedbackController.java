package com.impetus.ogos.user.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.dao.ICustomerFeedbackDao;
import com.impetus.ogos.user.model.CustomerFeedback;
import com.impetus.ogos.user.service.ICustomerFeedbackService;
/**
 *CustomerFeedbackController is handling the action of Customer Feedback.
 */
@RestController
@RequestMapping("CustomerFeedback")
public class CustomerFeedbackController {
	static final Logger LOGGER = Logger.getLogger(CustomerFeedbackController.class);
	@Autowired
	private ICustomerFeedbackService iCustomerFeedbackService;
	@Autowired
private ICustomerFeedbackDao customerFeedbackDao;
	/**get the customer feedback by userId.
	 * @return customerFeedback by userId
	 * @throws ResourceNotFound if customerFeedback not found by userId
	 */
	@GetMapping("getUserMail")
	public List<String> getUserId() throws ResourceNotFound {
		List<String> customerFeedback;
		try {
			LOGGER.debug("Inside CustomerFeedbackController class Inside  getUserId Method");
			customerFeedback = iCustomerFeedbackService.getUserEmail();
			LOGGER.debug("Customer Detail By email:" + customerFeedback);
			return customerFeedback;
		} catch (ResourceNotFound e) {
			LOGGER.error("User Not Found" + e);
			throw new ResourceNotFound("User not found" + e);
		}

	}
	/**Adding the customer Feedback details.
	 * @param customerFeedback is details of customer Feedback
	 */
	@PostMapping(path = "/addDetail")
	public void addDetail(CustomerFeedback customerFeedback) {
		if (customerFeedback != null) {
			iCustomerFeedbackService.addDetail(customerFeedback);
		} else {
			LOGGER.info("Give proper input");
		}
	}
	/**Show orderDetails by user Id.
	 * @param userId is user primary key
	 * @return orderList 
	 */
	@GetMapping("showOrderDetailsForFeedback/{userId}")
	public ResponseEntity<List<CustomerFeedback>> showOrderDetailsForFeedback(@PathVariable("userId") String userId) {
		List<CustomerFeedback> orderList = iCustomerFeedbackService.showOrderDetailsForFeedback(userId);
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	/**showCustomerFeedback by feedbackId.
	 * @param feedbackId is primary key of feedback table.
	 * @return  customerFeedback
	 */
	@GetMapping("showcustomerfeedbackbyid/{feedbackId}")
	public ResponseEntity<CustomerFeedback> showCustomerFeedbackById(@PathVariable("feedbackId") String feedbackId) {
		CustomerFeedback customerFeedback = customerFeedbackDao.showCustomerFeedbackById(feedbackId);
		return new ResponseEntity<>(customerFeedback, HttpStatus.OK);
	}

	/**updateFeedback.
	 * @param customerFeedback is object of customerFeedback
	 */
	@PutMapping("updateFeedback")
	public void updateFeedback(@RequestBody CustomerFeedback customerFeedback) {
		customerFeedbackDao.updateFeedback(customerFeedback);
	}

}
