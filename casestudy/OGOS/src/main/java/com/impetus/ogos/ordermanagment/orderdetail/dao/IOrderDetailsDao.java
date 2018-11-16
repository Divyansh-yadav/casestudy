package com.impetus.ogos.ordermanagment.orderdetail.dao;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;

/**
 *It is performing the save,find and update operation from database.
 */
public interface IOrderDetailsDao {
   
	//@Secured({"customer"})
    /**This method add the details of the order placed by customer.
     * @param orderDetails is detail of the order.
     * @param customerId taking the customerId as a input
     * @throws DaoException if any error occur in database query
     */
    void addOrderDetails(OrderDetails orderDetails, String customerId) throws DaoException;
}
