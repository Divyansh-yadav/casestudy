package com.impetus.ogos.ordermanagment.orderdetail.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.orderdetail.model.ProductDetails;
import com.impetus.ogos.ordermanagment.orderdetail.service.IOrderDetailsService;

/**
 * OrderDetailsController is handling the action of ProductDetails.
 */
@Controller
@RequestMapping("order")
public class OrderDetailsController {

	static final Logger LOGGER = Logger.getLogger(OrderDetailsController.class);
	@Autowired
	private IOrderDetailsService orderDetailsService;

	/**
	 * This method adding the user.
	 * 
	 * @param orderDetails taking OrderDetails Object as a input
	 * @return Return the created status
	 */
	@PostMapping("saveOrder")
	public ResponseEntity<ProductDetails> addUser(@RequestBody ProductDetails orderDetails) {
		return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
	}

	/**
	 * This method adding the order by userid.
	 * 
	 * @param userId     taking userId as a input
	 * @param customerId taking customerId as a input
	 * @return Return the created status and userId
	 * @throws DaoException if any exception occur in dao class
	 */
	@JsonIgnoreProperties("productId")
	@GetMapping("addorder/{user_id}/{customer_id}")
	public ResponseEntity<String> addOrderDetails(@PathVariable("user_id") String userId,
			@PathVariable("customer_id") String customerId) throws DaoException {

		try {
			LOGGER.debug("Inside OrderDetailsController classs Inside addOrder Method");
			String orderId = orderDetailsService.addOrderDetails(userId, customerId);
			return new ResponseEntity<>(orderId, HttpStatus.CREATED);
		} catch (DaoException e) {
			throw new DaoException("Order Not Added" + e);
		}
	}
}
