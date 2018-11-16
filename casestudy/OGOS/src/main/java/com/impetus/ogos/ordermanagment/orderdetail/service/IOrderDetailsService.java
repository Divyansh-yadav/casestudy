package com.impetus.ogos.ordermanagment.orderdetail.service;

import org.springframework.security.access.annotation.Secured;

import com.impetus.ogos.exception.DaoException;

/**
 * Define the add Abstract method in this interface.
 */
public interface IOrderDetailsService {
	/**
	 * This method add the details of the order placed by customer.
	 * 
	 * @param userId     is id of user
	 * @param customerId is id of customer
	 * @throws DaoException if any exception occur in Dao class
	 */
	@Secured({ "ROLE_CUSTOMER",  "ROLE_SERVICEPROVIDER" })
	String addOrderDetails(String userId, String customerId) throws DaoException;
}
