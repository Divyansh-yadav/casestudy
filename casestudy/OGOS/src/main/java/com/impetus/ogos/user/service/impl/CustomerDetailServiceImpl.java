package com.impetus.ogos.user.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.dao.ICustomerDetailDao;
import com.impetus.ogos.user.model.CustomerDetail;
import com.impetus.ogos.user.service.ICustomerDetailService;

/**
 * Implemented the ICustomerDetailService and overriding the method.
 */
@Service
public class CustomerDetailServiceImpl implements ICustomerDetailService {
	static final Logger LOGGER = Logger.getLogger(CustomerDetailServiceImpl.class);
	static final String SERVICEEXCEPTION="ServiceException";
	@Autowired
	private ICustomerDetailDao customerDetailDao;

	@Override
	public void addCustomerDetails(CustomerDetail customerDetail) throws DaoException {
		try {
			LOGGER.debug("Inside CustomerDetailServiceImpl class Inside  addCustomerDetails Method");
			customerDetailDao.addCustomerDetails(customerDetail);
			LOGGER.debug("Added:" + customerDetail);
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION+ e);
			throw new DaoException(SERVICEEXCEPTION+ e);
		}
	}

	@Override
	public List<CustomerDetail> getAllCustomerDetails() throws ResourceNotFound {
		List<CustomerDetail> customerList;
		try {
			LOGGER.debug("Inside CustomerDetailServiceImpl class Inside  getAllCustomerDetails Method");
			customerList = customerDetailDao.getAllCustomerDetails();
			LOGGER.debug("CustomerInfo:"+customerList);
			return customerList;
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION+e);
			throw new ResourceNotFound();
		}
		
	}

	@Override
	public List<CustomerDetail> getCustomerByUserId(String userId) {
		LOGGER.debug("Inside CustomerDetailServiceImpl class Inside  getCustomerByUserId Method");
		List<CustomerDetail> customerDetail = customerDetailDao.getCustomerByUserId(userId);
		LOGGER.debug("Customer Info By User Id"+customerDetail);
		return customerDetail;
	}

	@Override
	public CustomerDetail getCustomerById(String customerId) throws ResourceNotFound {
		CustomerDetail customerDetail;
		try {
			LOGGER.debug("Inside CustomerDetailServiceImpl class Inside  getCustomerById Method");
			customerDetail = customerDetailDao.getCustomerById(customerId);
			LOGGER.debug("Customer Info By Customer Id"+customerDetail);
			return customerDetail;
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION+e);
			throw new ResourceNotFound(SERVICEEXCEPTION+e);
		}
		
	}
	
	
}
