package com.impetus.ogos.ordermanagment.orderdetail.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.ordermanagment.cart.service.ICartService;
import com.impetus.ogos.ordermanagment.orderdetail.dao.IOrderDetailsDao;
import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;
import com.impetus.ogos.ordermanagment.orderdetail.model.ProductDetails;
import com.impetus.ogos.ordermanagment.orderdetail.service.IOrderDetailsService;
import com.impetus.ogos.user.dao.IUserDao;
import com.impetus.ogos.user.model.User;
import com.impetus.ogos.util.SentMail;
import com.impetus.ogos.vo.CartProduct;

/**
 * Implemented the IOrderDetailsService and overriding the method.
 */
@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	static final Logger LOGGER = Logger.getLogger(OrderDetailsServiceImpl.class);
	@Autowired
	private IOrderDetailsDao orderDetailsDao;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IUserDao userDao;
	@Autowired
	private SentMail mail;

	@Override
	public String addOrderDetails(String userId, String customerId) throws DaoException {

		OrderDetails orderDetails = new OrderDetails();
		List<CartProduct> cartProduct;
		try {
			LOGGER.debug("Inside OrderDetailsServiceImpl classs Inside addOrderDetails Method");
			cartProduct = cartService.getCartByUser(userId);
			ProductDetails productDetails = new ProductDetails();
			productDetails.setUserId(userId);
			double price = 0.0;
			double weight = 0.0;
        
			JSONArray array = new JSONArray();
			for (CartProduct cartProduct2 : cartProduct) {
			
				double p = cartProduct2.getPrice();
				int q = cartProduct2.getQuantity();
				double w = cartProduct2.getWeight();
				price = price + p * q;
				weight = weight + w * q;
				Products product = cartProduct2.getProduct();
if(product.getQuantity()>=q) {
					int remANING = product.getQuantity() -q;
					product.setQuantity(remANING);
				}

				JSONObject item = new JSONObject();
				
					item.put("productId", product.getProductId());
					item.put("productName", product.getProductName());
					item.put("quantity", q);
					item.put("weight", product.getWeight());
					item.put("price", product.getPrice());
					array.put(item);

				
			}
			productDetails.setProductDetails(array);
			productDetails.setTotalAmount(price);
			productDetails.setTotalWeight(weight);
			orderDetails.setTotalAmount(productDetails.getTotalAmount());
			orderDetails.setTotalAmount(productDetails.getTotalWeight());
			orderDetails.setProductDetail(productDetails.getProductDetails());
			orderDetails.setUserId(productDetails.getUserId());
			User user = userDao.getUserByID(userId);
			mail.mail(user.getEmail(), "Your order has been successfully placed");
			cartService.removeCartByUserId(userId);
			orderDetailsDao.addOrderDetails(orderDetails, customerId);
			return orderDetails.getOrderId();
		} catch (DaoException | ResourceNotFound |JSONException e) {
			throw new DaoException("Service Exception" + e);
		}

	}

}
