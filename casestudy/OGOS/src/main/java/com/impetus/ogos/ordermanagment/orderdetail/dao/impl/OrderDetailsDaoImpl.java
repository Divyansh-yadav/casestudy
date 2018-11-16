package com.impetus.ogos.ordermanagment.orderdetail.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.orderdetail.dao.IOrderDetailsDao;
import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;
import com.impetus.ogos.user.model.CustomerDetail;
import com.impetus.ogos.user.model.ServiceProvider;
import com.impetus.ogos.user.model.User;
import com.impetus.ogos.user.service.ICustomerDetailService;
import com.impetus.ogos.user.service.IServiceProviderService;

/**
 * This class implements the method related to the IOrderDetailsDao.
 */
@Repository
public class OrderDetailsDaoImpl implements IOrderDetailsDao {

	static final Logger LOGGER = Logger.getLogger(OrderDetailsDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private IServiceProviderService serviceProviderService;

	@Autowired
	private ICustomerDetailService customerDetailService;

	@Override
	@Transactional
	public void addOrderDetails(OrderDetails orderDetails, String customerId) throws DaoException {
		try {
			LOGGER.debug("Inside OrderDetailsDaoImpl classs Inside addOrderDetails Method");
			ServiceProvider sp = new ServiceProvider();
			String userId = orderDetails.getUserId();
			User user = entityManager.find(User.class, userId);
			orderDetails.setUser(user);

			entityManager.persist(orderDetails);
			sp.setOrderId(orderDetails);
			sp.setUserId(user);
			CustomerDetail customerDetail = customerDetailService.getCustomerById(customerId);

			sp.setCustomerDetail(customerDetail);
			serviceProviderService.addOrder(sp);
		} catch (Exception e) {
			throw new DaoException("DaoException" + e);
		}
	}
}
