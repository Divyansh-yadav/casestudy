package com.impetus.ogos.user.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.ServiceProvider;
import com.impetus.ogos.user.service.IServiceProviderService;
/**
 *ServiceProviderController is handling the action of ServiceProvider.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("service")
public class ServiceProviderController {
    static final Logger LOGGER = Logger.getLogger(ServiceProviderController.class);
    @Autowired
    private IServiceProviderService serviceProviderService;
    /**Show order deatils.
     * @return list of serviceProvider 
     * @throws ResourceNotFound if service provider not found
     */
    @GetMapping("showOrders")
    public ResponseEntity<List<ServiceProvider>> showOrderDetails() throws ResourceNotFound {
        List<ServiceProvider> serviceProvider;
        try {
            LOGGER.debug("Inside ServiceProviderController class Inside  showOrderDetails Method");
            serviceProvider = serviceProviderService.showOrderDetails();
            LOGGER.debug("Orders:" + serviceProvider);
            return new ResponseEntity<>(serviceProvider, HttpStatus.CREATED);
        } catch (ResourceNotFound e) {
            LOGGER.error("Orders Not Found" + e);
            throw new ResourceNotFound("Orders Not Found" + e);
        }
    }
    /**Update the productCategory by providerId.
     * @param providerId is service provider primary key
     * @param deliveryStatus is status of product
     * @return status created
     * @throws ResourceNotFound is productCategory not found or not updated
     */
    @GetMapping("updateStatus/{provider_pk}/{delivery_status}")
    public ResponseEntity<ServiceProvider> updateProductCategory(@PathVariable("provider_pk") String providerId,
            @PathVariable("delivery_status") String deliveryStatus) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside ServiceProviderController class Inside  updateProductCategory Method");
            serviceProviderService.updateStatus(providerId, deliveryStatus);
            LOGGER.debug("Updated!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ResourceNotFound e) {
            LOGGER.error("Not Updated" + e);
            throw new ResourceNotFound("Not Updated" + e);
        }

    }
    /**show order details for traking. 
     * @param userId is primary key of user.
     * @return trackOrderList
     */
    @GetMapping("trackOrder/{userId}")
    public ResponseEntity<ArrayNode> showOrderDetailsForTrackingOrder(@PathVariable("userId") String userId) {
        ArrayNode trackOrderList = serviceProviderService.showOrderDetailsForTrackingOrder(userId);
        
        return new ResponseEntity<>(trackOrderList,HttpStatus.CREATED);

    }
}
