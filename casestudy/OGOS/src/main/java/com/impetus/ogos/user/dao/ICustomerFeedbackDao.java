package com.impetus.ogos.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.model.CustomerFeedback;

/**
 * It is an interface. This class holds the method that interacts with the
 * Customer Feedback table.
 */
@Repository
public interface ICustomerFeedbackDao {
	/**
	 * This method fetches the userEmail.
	 * @return list of user email
	 * @throws DaoException if any exception occur in dao class
	 */
    List<String> getUserEmail() throws DaoException;
    /**
	 * This method add the details related to the CustomerFeedback. 
	 * @param customerFeedback is object CustomerFeedback.
	 */
	void addDetail(CustomerFeedback customerFeedback);
	
    /**This method fetches the orderDetails by userId.
     * @param userId is primary key of user.
     * @return list of customerFeedback
     */
    List<CustomerFeedback> showOrderDetailsForFeedback(String userId);
    
    /**This method fetches the CustomerFeedback by feedbackId.
     * @param feedbackId is primary key of feedback table
     * @return CustomerFeedback
     */
    CustomerFeedback showCustomerFeedbackById(String feedbackId);
    
    /**
     * @param customerFeedback is customerFeedback
     */
    void updateFeedback(CustomerFeedback customerFeedback);

}