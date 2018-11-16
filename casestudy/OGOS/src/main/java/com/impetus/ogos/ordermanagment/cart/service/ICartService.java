package com.impetus.ogos.ordermanagment.cart.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.impetus.ogos.vo.CartProduct;
import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.ordermanagment.cart.model.Cart;

/**
 * Define the add ,get all Abstract method in this interface.
 */
public interface ICartService {
	/**
	 * @param cart taking cart as a input
	 * @throws DaoException if any exception occur in dao class
	 */
	@Secured({ "ROLE_CUSTOMER" })
	void addToCart(Cart cart) throws DaoException;

	/**
	 * @param userId taking userId as a input
	 * @return Return the cart by userId
	 * @throws ResourceNotFound If cart not found by userId
	 */
	@Secured({ "ROLE_CUSTOMER" })
	List<CartProduct> getCartByUser(String userId) throws ResourceNotFound;

	/**
	 * @param cartId   taking cartId as a input
	 * @param quantity taking quantity as a input
	 * @throws ResourceNotFound If cart not found by cartId
	 */
	@Secured({ "ROLE_CUSTOMER" })
	void addQuantityToCart(String cartId, String quantity) throws ResourceNotFound;

	/**
	 * @param userId taking userId as a input
	 * @throws ResourceNotFound If cart not found by userId
	 */
	@Secured({ "ROLE_CUSTOMER" })
	void removeCartByUserId(String userId) throws ResourceNotFound;

	/**
	 * @param cartId taking cartId as a input
	 * @throws ResourceNotFound If cart not found by cartId
	 */
	@Secured({ "ROLE_CUSTOMER" })
	void removeCart(String cartId) throws ResourceNotFound;

List<String> checkQuantity(String cat_id);  
}
