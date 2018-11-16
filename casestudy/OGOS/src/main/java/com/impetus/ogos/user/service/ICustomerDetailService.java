package com.impetus.ogos.user.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.CustomerDetail;

/**
 *Define the add ,get all Abstract method in this interface.
 */
public interface ICustomerDetailService {
    /**This Method is Adding the customer Deatils.
     * @param customerDetail is object of CustomerDetail
     * @throws DaoException if any exception occur in dao class
     */
	@Secured({ "ROLE_CUSTOMER" })
    void addCustomerDetails(CustomerDetail customerDetail) throws DaoException;

    /**This Method is fetches all the cusomer.
     * @return list of customer Details
     * @throws ResourceNotFound if customer details not found
     */
    List<CustomerDetail> getAllCustomerDetails() throws ResourceNotFound;
    
    /**This method is fetches the customer by user id.
     * @param userId is primary key of user.
     * @return list of customer bu yser id
     */
    List<CustomerDetail> getCustomerByUserId(String userId);
    
    /**This Method is fetches the customer by customer id.
     * @param customerId is primary key of customer
     * @return customer by customer id
     * @throws ResourceNotFound id customer not found by customer id
     */
    CustomerDetail getCustomerById(String customerId) throws ResourceNotFound;

}