package com.impetus.ogos.user.dao;

import java.util.List;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.model.CustomerDetail;

/** It is an interface. This class holds the method that interacts with the Customer Detail table.
 * 
 */
public interface ICustomerDetailDao {
    /** This method add the details related to the customer.
     * 
     * @param customerDetail
     *            is the object of CustomerDetail and holds the detail of the customer. 
     * @throws DaoException */
	//@Secured({"customer"})
    void addCustomerDetails(CustomerDetail customerDetail) throws DaoException;

    /** This is abstract method. It fetches all the details of the customer.
     * 
     * @return the list of all the customers. 
     * @throws DaoException */
	//@Secured({"customer","admin"})
    List<CustomerDetail> getAllCustomerDetails() throws DaoException;

    /** This method fetches the customer using user id.
     * 
     * @param userId
     *            is the unique id of the user.
     * @return the a customer related to particular id. */
    List<CustomerDetail> getCustomerByUserId(String userId);

    /** This method fetches the customer using customer id.
     * 
     * @param customerId
     *            is the unique customer id.
     * @return the details of the customer related to the respective id. 
     * @throws DaoException */
    CustomerDetail getCustomerById(String customerId) throws DaoException;
}
