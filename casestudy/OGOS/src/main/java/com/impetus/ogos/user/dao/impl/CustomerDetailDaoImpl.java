package com.impetus.ogos.user.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.dao.ICustomerDetailDao;
import com.impetus.ogos.user.model.CustomerDetail;
import com.impetus.ogos.user.model.User;

/**
 * This class stores the details of the customers.
 * 
 */
@Repository
public class CustomerDetailDaoImpl implements ICustomerDetailDao {
	static final String DAOEXCEPTION="DaoException";
	static final Logger LOGGER = Logger.getLogger(CustomerDetailDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addCustomerDetails(CustomerDetail customerDetail) throws DaoException {
		try {
			LOGGER.debug("Inside CustomerDetailDaoImpl class Inside  addCustomerDetails Method");
			String userId = customerDetail.getUserid();
			User user = entityManager.find(User.class, userId);
			LOGGER.debug("User Info" + user);
			customerDetail.setUser(user);
			entityManager.persist(customerDetail);
			LOGGER.debug("Added:" + customerDetail);
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION + e);
			throw new DaoException(DAOEXCEPTION + e);
		}
	}

	@Override
	public List<CustomerDetail> getAllCustomerDetails() throws DaoException {
		try {
			LOGGER.debug("Inside CustomerDetailDaoImpl class Inside  getAllCustomerDetails Method");
			String hql = "FROM CustomerDetail";
			@SuppressWarnings("unchecked")
			List<CustomerDetail> customerList = entityManager.createQuery(hql).getResultList();
			LOGGER.debug("Customer Info"+customerList);
			return customerList;
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION+e);
			throw new DaoException(DAOEXCEPTION + e);
		}
	}

	@Override
	public List<CustomerDetail> getCustomerByUserId(String userId) {
		LOGGER.debug("Inside CustomerDetailDaoImpl class Inside  getCustomerByUserId Method");
		User user = entityManager.find(User.class, userId);
		@SuppressWarnings("unchecked")
		List<CustomerDetail> details = entityManager.createQuery("SELECT c FROM CustomerDetail c WHERE c.user = :user")
				.setParameter("user", user).getResultList();
		LOGGER.debug("Customer Info By User Id"+details);
		return details;
	}

	@Override
	public CustomerDetail getCustomerById(String customerId) throws DaoException {
		try {
			LOGGER.debug("Inside CustomerDetailDaoImpl class Inside  getCustomerById Method");
		CustomerDetail customerDetail = entityManager.find(CustomerDetail.class, customerId);
		LOGGER.debug("Customer Info By Customer Id"+customerDetail);
		return customerDetail;
		}catch(Exception e) {
			LOGGER.error(DAOEXCEPTION+e);
			throw new DaoException(DAOEXCEPTION+e);
		}
	}
	
	 
}
