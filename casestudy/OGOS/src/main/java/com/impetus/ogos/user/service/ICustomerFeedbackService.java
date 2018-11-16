package com.impetus.ogos.user.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.CustomerFeedback;

/**
 *Define the add Abstract method in this interface.
 */
@Service
public  interface ICustomerFeedbackService {

    /**This method fetches the list of user email.
     * @return userEmail
     * @throws ResourceNotFound if userEmail not found.
     * 
     */
    List<String> getUserEmail() throws ResourceNotFound;

	/**THis method add the details of customer in customer feedback.
	 * @param customerFeedback is object of customer feedback.
	 */
    @Secured({"ROLE_SERVICEPROVIDER", "ROLE_CUSTOMER"})
    void addDetail(CustomerFeedback customerFeedback);
	
	/**This method fetches the order details of particular user.
	 * @param userId is primary key of user.
	 * @return order details of user.
	 */
	List<CustomerFeedback> showOrderDetailsForFeedback(String userId);

}