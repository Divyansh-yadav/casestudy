package com.impetus.ogos.user.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.dao.IServiceProviderDao;
import com.impetus.ogos.user.model.ServiceProvider;
import com.impetus.ogos.user.service.IServiceProviderService;
/**
 *Implemented the IServiceProviderService and overriding the method.
 */
@Service
public class ServiceProviderServiceImpl implements IServiceProviderService {
	static final Logger LOGGER = Logger.getLogger(ServiceProviderServiceImpl.class);
	static final String SERVICEEXCEPTION="ServiceException";
    @Autowired
   private  IServiceProviderDao serviceProviderDao;
@Override
    public List<ServiceProvider> showOrderDetails() throws ResourceNotFound {
        try {
        	LOGGER.debug("Inside ServiceProviderServiceImpl class Inside  showOrderDetails Method");
			return serviceProviderDao.showOrderDetails();
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION+e);
			throw new ResourceNotFound(SERVICEEXCEPTION+e);
		}
    }
    
	@Override
	public void updateStatus(String providerId, String deliveryStatus) throws ResourceNotFound {
		try {
			LOGGER.debug("Inside ServiceProviderServiceImpl class Inside  updateProductCategory Method");
			serviceProviderDao.updateStatus(providerId,deliveryStatus);
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION+e);
			throw new ResourceNotFound(SERVICEEXCEPTION+e);
		}
	}

	@Override
	public void addOrder(ServiceProvider serviceProvider) {
		LOGGER.debug("Inside ServiceProviderServiceImpl class Inside  addOrder Method");
		serviceProviderDao.addOrder(serviceProvider);
		
	}

    @Override
    public ArrayNode showOrderDetailsForTrackingOrder(String userId) {
        List<ServiceProvider> trackOrderList=serviceProviderDao.showOrderDetailsForTrackingOrder(userId);
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();
         jsonArray.removeAll();
        for (Object result : trackOrderList) {
            LOGGER.debug("Creating Json Array"+result);
            Object[] items = (Object[]) result;
            ObjectNode json = mapper.createObjectNode();
            json.put("OrderId", items[0].toString());
            json.put("deliveryStatus", items[1].toString());
            json.put("deliveryDate", items[2].toString());
            jsonArray.add(json);
        }
        
        LOGGER.debug("Final JSON"+jsonArray);
        return jsonArray;
    }
}
