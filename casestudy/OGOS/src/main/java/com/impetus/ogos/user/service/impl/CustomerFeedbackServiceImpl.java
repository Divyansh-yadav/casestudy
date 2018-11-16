package com.impetus.ogos.user.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.dao.ICustomerFeedbackDao;
import com.impetus.ogos.user.model.CustomerFeedback;
import com.impetus.ogos.user.service.ICustomerFeedbackService;
/**
 *Implemented the ICustomerFeedbackService and overriding the method.
 */
@Service
public class CustomerFeedbackServiceImpl implements ICustomerFeedbackService {
	static final Logger LOGGER = Logger.getLogger(CustomerFeedbackServiceImpl.class);
    @Autowired
    private ICustomerFeedbackDao iCustomerFeedbackDao;

    @Override
    public List<String> getUserEmail() throws ResourceNotFound {
        try {
        	LOGGER.debug("Inside CustomerFeedbackDaoImpl class Inside  getUserEmail Method");
			return iCustomerFeedbackDao.getUserEmail();
		} catch (DaoException e) {
			LOGGER.error("Service Exception"+e);
			throw new ResourceNotFound("Service Exception"+e);
		}
    }

	@Override
	public void addDetail(CustomerFeedback customerFeedback)  {
		iCustomerFeedbackDao.addDetail(customerFeedback);
	}

	@Override
    public List<CustomerFeedback> showOrderDetailsForFeedback(String userId) {
        return iCustomerFeedbackDao.showOrderDetailsForFeedback(userId);
    }
}
