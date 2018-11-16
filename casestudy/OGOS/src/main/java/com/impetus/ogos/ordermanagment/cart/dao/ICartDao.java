package com.impetus.ogos.ordermanagment.cart.dao;

import java.util.List;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.cart.model.Cart;
/**
 *It is performing the save,find and update operation from database.
 */
public interface ICartDao {
	//@Secured({"customer"})
	/**This method adding the cart.
	 * @param cart taking the cart as a input
	 * @throws DaoException if any exception occur in DataBase
	 */
	void addToCart(Cart cart) throws DaoException;
	//@SecuredaddToCart({"customer"})
	
	/**This method get cart by userid.
	 * @param userId taking the userId as a input
	 * @return Return the cart by userId
	 * @throws DaoException if any exception occur in DataBase
	 */
	List<Cart> getCartByUser(String userId) throws DaoException;
	/**This Method remove cart by userid.
	 * @param userId taking the userId as a input
	 * @throws DaoException if any exception occur in DataBase
	 */
	void removeCartByUserId(String userId) throws DaoException;
	/**THis method remove cart by cart id.
	 * @param cartId taking the cartId as a input
	 * @throws DaoException if any exception occur in DataBase
	 */
	void removeCart(String cartId) throws DaoException;
	/** This method add quantity to cart.
	 * @param cartId taking the cartId as a input
	 * @param quantity taking the quantity as a input
	 * @throws DaoException if any exception occur in DataBase
	 */
	void addQuantityToCart(String cartId, String quantity) throws DaoException;
	 
}
	