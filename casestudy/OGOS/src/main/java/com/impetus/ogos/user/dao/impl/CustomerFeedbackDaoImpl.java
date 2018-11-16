package com.impetus.ogos.user.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;
import com.impetus.ogos.user.dao.ICustomerFeedbackDao;
import com.impetus.ogos.user.model.CustomerFeedback;
import com.impetus.ogos.user.model.User;

/** This class stores the details of the customers Feedback. */
@Repository
public class CustomerFeedbackDaoImpl implements ICustomerFeedbackDao {
	static final String DAOEXCEPTION = "DaoException";
	@PersistenceContext
	private EntityManager entityManager;

	static final Logger LOGGER = Logger.getLogger(CustomerFeedbackDaoImpl.class);

	@Override
	public List<String> getUserEmail() throws DaoException {
		try {
			LOGGER.debug("Inside CustomerFeedbackDaoImpl class Inside  getUserEmail Method");
			@SuppressWarnings("unchecked")
			List<String> list = entityManager.createNativeQuery(
					"select distinct u.email ,cf.creationtime,u.user_id,u.customer_rating from service_provider sp,customer_feedback cf,user u where cf.feedback is null and cf.user_id=sp.user_id and sp.user_id=u.user_id")
					.getResultList();
			LOGGER.debug("Customer Detail By email:" + list);
			return list;
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION + e);
			throw new DaoException(DAOEXCEPTION + e);
		}
	}

	@Override
	public void addDetail(CustomerFeedback customerFeedback) {
		try {
			entityManager.persist(customerFeedback);
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION + e);
		}
	}

	@Override
	public List<CustomerFeedback> showOrderDetailsForFeedback(String userId) {
		String hql = "Select c From CustomerFeedback c where c.user =:user and c.feedback is NULL";
		User user = entityManager.find(User.class, userId);
		@SuppressWarnings("unchecked")
		List<CustomerFeedback> orderList = entityManager.createQuery(hql).setParameter("user", user).getResultList();
		LOGGER.debug("ORDER LIST " + orderList);
		return orderList;
	}

	@Override
	public CustomerFeedback showCustomerFeedbackById(String feedbackId) {
		return entityManager.find(CustomerFeedback.class, feedbackId);
	}

	@Transactional
	@Override
	public void updateFeedback(CustomerFeedback customerFeedback) {
		String userId = customerFeedback.getUserId();
		LOGGER.debug("USER ID " + userId);
		User user = entityManager.find(User.class, userId);
		String orderId = customerFeedback.getOrderId();
		LOGGER.debug("ORDER ID " + orderId);
		OrderDetails orderDetails = entityManager.find(OrderDetails.class, orderId);
		String feedback = customerFeedback.getFeedback();
		LOGGER.debug("Feedback Message " + feedback);
		String comments = customerFeedback.getComments();
		LOGGER.debug("COMMENTS " + comments);
		entityManager.createNamedQuery("updateFeedback").setParameter("user", user)
				.setParameter("orderDetails", orderDetails).setParameter("feedback", feedback)
				.setParameter("comments", comments).executeUpdate();
	}

}
