package com.impetus.ogos.ordermanagment.cart.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.ordermanagment.cart.dao.impl.CartDaoImpl;
import com.impetus.ogos.ordermanagment.cart.model.Cart;
import com.impetus.ogos.ordermanagment.cart.service.ICartService;
import com.impetus.ogos.vo.CartProduct;
/**
 *CartController is handling the action of cart.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cart")
public class CartController {
	static final Logger LOGGER = Logger.getLogger(CartDaoImpl.class);
	@Autowired
	private ICartService cartService;
	/**This Method is adding the cart.
	 * @param cart taking the cart as a input
	 * @return Return the created status.
	 * @throws DaoException If any exception occur in DaoClass.
	 */
	@PostMapping("addToCart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) throws DaoException {
		try {
			LOGGER.debug("Inside CartController classs Inside addToCart Method");
			cartService.addToCart(cart);
			LOGGER.debug("Added " + cart);
			return new ResponseEntity<>(cart, HttpStatus.CREATED);
		} catch (DaoException e) {
			LOGGER.error("Not Added" + e);
			throw new DaoException("Cart not added" + e);
		}

	}
	/**This method is fetches the cart by userid.
	 * @param userId taking the userId as a input
	 * @return Return the cart by userId
	 * @throws ResourceNotFound if cart not found by userId
	 */
	@GetMapping("getcartbyuser/{userId}")
	public List<CartProduct> getCartByUser(@PathVariable("userId") String userId) throws ResourceNotFound {
		List<CartProduct> carts;
		try {
			LOGGER.debug("Inside CartController classs Inside getCartByUser Method");
			carts = cartService.getCartByUser(userId);
			LOGGER.debug("Carts:"+carts);
			return carts;
		} catch (ResourceNotFound e) {
			LOGGER.error("Cart Not Found"+e);
			throw new ResourceNotFound("Cart Not Found"+e);
		}

	}
	/**	This method is Update the cart.
	 * @param cartId taking the cartId as a input 
	 * @param quantity taking the quantity as a input 
	 * @throws ResourceNotFound if cart not found by cartId or not updated
	 */
	@PostMapping("updateQuantity/{cartId}/{quantity}")
	public void addQuantityToCart(@PathVariable("cartId") String cartId, @PathVariable("quantity") String quantity) throws ResourceNotFound {
		try {
		    LOGGER.debug(cartId+"        "+quantity);
			LOGGER.debug("Inside CartController classs Inside addQuantityToCart Method");
			cartService.addQuantityToCart(cartId, quantity);
			LOGGER.debug("Added Quantity"+cartId+","+quantity);
		} catch (ResourceNotFound e) {
			LOGGER.error("Cart Id is not present"+e);
			throw new ResourceNotFound("Cart id not present"+e); 
		}
	}
	/**
	 * @param userId taking the products as a input
	 * @return Return the cart by userId
	 * @throws ResourceNotFound if cart not found by userId
	 */
	@GetMapping("getcartbyvalue/{userId}")
	public double getCartByvalue(@PathVariable("userId") String userId) throws ResourceNotFound {
		List<CartProduct> carts;
		try {
			LOGGER.debug("Inside CartController classs Inside getCartByvalue Method");
			carts = cartService.getCartByUser(userId);
			double price = 0.0;
			for (CartProduct cartProduct : carts) {
				double p = cartProduct.getPrice();
				int q = cartProduct.getQuantity();
				price = price + p * q;
			}
			LOGGER.debug("Cart By value"+price);
			return price;
		} catch (ResourceNotFound e) {
			LOGGER.error("Cart By value Not Found"+e);
			throw new ResourceNotFound("Cart By value Not Found"+e);
		}

	}
@GetMapping("checkquantity/{userId}")
	public List<String> checkCart(@PathVariable("userId") String userId) throws ResourceNotFound {
	   
		
		    LOGGER.debug("**** Removing Item From Cart");
			LOGGER.debug("Inside CartController classs Inside checkquantity Method");
			List<String> NA = cartService.checkQuantity(userId);
			
		
		return NA;
	}

	/**
	 * @param userId taking the userId as a input
	 * @throws ResourceNotFound if cart not found by userId
	 */
	@GetMapping("removecart/{userId}")
	public void removeCartByUserId(@PathVariable("userId") String userId) throws ResourceNotFound {
	   
		try {
			LOGGER.debug("Inside CartController classs Inside removeCartByUserId Method");
			cartService.removeCartByUserId(userId);
			LOGGER.debug("Removed Cart!");
		} catch (ResourceNotFound e) {
			LOGGER.error("Cart Not Removed");
			throw new ResourceNotFound("User id not found"+e);
		}
	}
	/**
	 * @param cartId taking the cartId as a input
	 * @throws ResourceNotFound if cart not found by cartId
	 */
	@GetMapping("removeitem/{cartId}")
	public void removeCart(@PathVariable("cartId") String cartId) throws ResourceNotFound {
	   
		try {
		    LOGGER.debug("**** Removing Item From Cart");
			LOGGER.debug("Inside CartController classs Inside removeCart Method");
			cartService.removeCart(cartId);
			LOGGER.debug("Removed Cart!");
		} catch (ResourceNotFound e) {
			LOGGER.error("Cart Not Removed"+e);
			throw new ResourceNotFound("Cart Id not Found"+e);
		}
	}
}
