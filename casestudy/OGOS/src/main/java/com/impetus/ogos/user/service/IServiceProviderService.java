package com.impetus.ogos.user.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.ServiceProvider;

/**
 * Define the add ,get all Abstract method in this interface.
 */
public interface IServiceProviderService {
	/**
	 * This method fetches the list of service provider.
	 * 
	 * @return list of orderDetails
	 * @throws ResourceNotFound if orderDetails not found.
	 */

	@Secured({ "ROLE_SERVICEPROVIDER" })
	List<ServiceProvider> showOrderDetails() throws ResourceNotFound;

	/**
	 * This method update the product category.
	 * 
	 * @param providerId     is primary key of service provider.
	 * @param deliveryStatus is status of customer order.
	 * @throws ResourceNotFound if product category not found for update.
	 */
	@Secured({ "ROLE_SERVICEPROVIDER", "ROLE_CUSTOMER" })
	void updateStatus(String providerId, String deliveryStatus) throws ResourceNotFound;

	/**
	 * This method adding the order in service provider.
	 * 
	 * @param serviceProvider is object of service provider.
	 */
	void addOrder(ServiceProvider serviceProvider);

	/**
	 * This method fetches orderDetails by user id.
	 * 
	 * @param userId is primary key of user.
	 * @return orderDetails by userId.
	 */
	@Secured({ "ROLE_SERVICEPROVIDER","ROLE_CUSTOMER" })
	ArrayNode showOrderDetailsForTrackingOrder(String userId);
}
