package com.impetus.ogos.user.dao;

import java.util.List;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.model.ServiceProvider;

/**
 * It is an interface. This class holds the method that interacts with the
 * Service Provider table.
 */
public interface IServiceProviderDao {
	/**This method fetches the OrderDetails.
	 * @return list of service Provider
	 * @throws DaoException if any error occur in dao class
	 */
	List<ServiceProvider> showOrderDetails() throws DaoException;

	/**This method update the status of customer order.
	 * @param providerId is primary key of Service Provider.
	 * @param deliveryStatus is status of customer order.
	 * @throws DaoException  if any error occur in dao class
	 */
	void updateStatus(String providerId, String deliveryStatus) throws DaoException;

	/**This method add order in service provider.
	 * @param serviceProvider is object of serviceProvider
	 */
	void addOrder(ServiceProvider serviceProvider);

	/**This method fetches the OrderDetails For TrackingOrder.
	 * @param userId is primary key of user.
	 * @return list of serviceProvider.
	 */
	List<ServiceProvider> showOrderDetailsForTrackingOrder(String userId);
}
