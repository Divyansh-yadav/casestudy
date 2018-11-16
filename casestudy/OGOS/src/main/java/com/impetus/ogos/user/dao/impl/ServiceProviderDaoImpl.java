package com.impetus.ogos.user.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.dao.ICustomerFeedbackDao;
import com.impetus.ogos.user.dao.IServiceProviderDao;
import com.impetus.ogos.user.model.CustomerFeedback;
import com.impetus.ogos.user.model.ServiceProvider;
import com.impetus.ogos.util.SentMail;

/** This class stores the details of the Service Provider. */
@Transactional
@Repository
public class ServiceProviderDaoImpl implements IServiceProviderDao {
	static final String DAOEXCEPTION = "DaoException";
	static final Logger LOGGER = Logger.getLogger(ServiceProviderDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	private CustomerFeedback customerFeedback = new CustomerFeedback();
	@Autowired
	private ICustomerFeedbackDao iCustomerFeedbackDao;

	@Autowired
	private SentMail sentMail;

	@Override
	public List<ServiceProvider> showOrderDetails() throws DaoException {
		try {
			LOGGER.debug("Inside ServiceProviderDaoImpl class Inside  showOrderDetails Method");
			String hql = "From ServiceProvider  s  WHERE s.deliveryStatus !='Delievered' ORDER BY s.creationtime DESC ";
			@SuppressWarnings("unchecked")
			List<ServiceProvider> orderList = entityManager.createQuery(hql).getResultList();
			LOGGER.debug("Order List:" + orderList);
			return orderList;
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION + e);
			throw new DaoException(DAOEXCEPTION + e);
		}
	}

	@Override
	public void updateStatus(String providerId, String deliveryStatus) {
		ServiceProvider serviceProvider;

		LOGGER.debug("UPDATING THE CUSTOMER FEDBACK");
		Query hql = entityManager.createNamedQuery("getDetailsByProviderId");
		hql.setParameter("providerid", providerId);
		serviceProvider = (ServiceProvider) hql.getSingleResult();
		String text = "Your Order has been " + deliveryStatus;
		sentMail.mail(serviceProvider.getUserId().getEmail(), text);
		if ("Delievered".equals(deliveryStatus)) {
			customerFeedback.setUser(serviceProvider.getUserId());
			customerFeedback.setOrderDetails(serviceProvider.getOrderId());
			iCustomerFeedbackDao.addDetail(customerFeedback);

		}
		Query query = entityManager.createNativeQuery(
				"update service_provider set delivery_status= :deliveryStatus where provider_pk =:providerId");
		LOGGER.debug("UPDATING ");
		query.setParameter("providerId", providerId);
		query.setParameter("deliveryStatus", deliveryStatus);
		LOGGER.debug(query.executeUpdate());
	}

	@Override
	public void addOrder(ServiceProvider serviceProvider) {
		LOGGER.debug("Inside ServiceProviderDaoImpl class Inside  addOrder Method");
		entityManager.persist(serviceProvider);
	}

	@Override
	public List<ServiceProvider> showOrderDetailsForTrackingOrder(String userId) {
		LOGGER.debug("*********Tracking Order List***********");
		String hql = "select provider.order_id,provider.delivery_status, date(modificationtime) from service_provider provider where provider.user_id=:userId ORDER BY modificationtime DESC";
		@SuppressWarnings("unchecked")
		List<ServiceProvider> trackOrderList = entityManager.createNativeQuery(hql).setParameter("userId", userId)
				.getResultList();
		LOGGER.debug("Track Order List " + trackOrderList);
		return trackOrderList;
	}
}
