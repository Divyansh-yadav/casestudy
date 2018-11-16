package com.impetus.ogos.user.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.CustomerDetail;
import com.impetus.ogos.user.service.ICustomerDetailService;

/**
 * CustomerDetailController is handling the action of CustomerDetail.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerDetailController {

	static final Logger LOGGER = Logger.getLogger(CustomerDetailController.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private ICustomerDetailService customerDetailService;

	/**
	 * It is adding the customerDetails.
	 * 
	 * @param customerDetail is the Object of CustomerDeatil
	 * @return customerDetail and created status
	 * @throws DaoException if any exception occur in dao class
	 */
	@PostMapping("addCustomerDetails")
	public ResponseEntity<CustomerDetail> addCustomerDetails(@RequestBody CustomerDetail customerDetail)
			throws DaoException {

		try {
			LOGGER.debug("Inside CustomerDetailController class Inside  addCustomerDetails Method");
			LOGGER.debug("User Id:" + session.getAttribute("userid"));
			customerDetailService.addCustomerDetails(customerDetail);
			return new ResponseEntity<>(customerDetail, HttpStatus.CREATED);
		} catch (DaoException e) {
			LOGGER.error("Not Added" + e);
			throw new DaoException("Not Added" + e);
		}

	}

	/**
	 * Get all customer Details.
	 * 
	 * @return Get All CustomerDetails
	 * @throws ResourceNotFound is customer details not found
	 */
	@GetMapping("getAllCustomerDetails")
	public ResponseEntity<List<CustomerDetail>> getAllCustomerDetails() throws ResourceNotFound {
		List<CustomerDetail> list;
		try {
			LOGGER.debug("Inside CustomerDetailController class Inside  getAllCustomerDetails Method");
			list = customerDetailService.getAllCustomerDetails();
			LOGGER.debug("Customer Info:" + list);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ResourceNotFound e) {
			LOGGER.error("Customer Not Found" + e);
			throw new ResourceNotFound("Customer List Not Found" + e);
		}

	}

	/**
	 * By this method get Customer by user id.
	 * 
	 * @param userId is unique key of user
	 * @return customerDetail by userId
	 */
	@GetMapping("getbyuserid/{userId}")
	public ResponseEntity<List<CustomerDetail>> getCustomerByUserId(@PathVariable("userId") String userId) {
		List<CustomerDetail> customerDetail = customerDetailService.getCustomerByUserId(userId);
		return new ResponseEntity<>(customerDetail, HttpStatus.OK);
	}

	/**
	 * By this method get Customer Detail by customer Id.
	 * 
	 * @param customerId is the unique key of customer
	 * @return customerDetail by customerId
	 * @throws ResourceNotFound if customer details not found
	 */
	@GetMapping("{customerId}")
	public ResponseEntity<CustomerDetail> getCustomerById(@PathVariable("customerId") String customerId)
			throws ResourceNotFound {

		CustomerDetail customerDetail;
		try {
			LOGGER.debug("Inside CustomerDetailController class Inside  getCustomerById Method");
			customerDetail = customerDetailService.getCustomerById(customerId);
			LOGGER.debug("Customer Info By Customer Id" + customerDetail);
			return new ResponseEntity<>(customerDetail, HttpStatus.OK);
		} catch (ResourceNotFound e) {
			LOGGER.error("Customer Not Found" + e);
			throw new ResourceNotFound("Customer not found" + e);
		}

	}
}
