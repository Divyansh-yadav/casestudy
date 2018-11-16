package com.impetus.ogos.ordermanagment.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.inventory.products.service.IProductsService;
import com.impetus.ogos.ordermanagment.cart.dao.ICartDao;
import com.impetus.ogos.ordermanagment.cart.model.Cart;
import com.impetus.ogos.ordermanagment.cart.service.ICartService;
import com.impetus.ogos.vo.CartProduct;
/**
 * Implemented the ICartService and overriding the method.
 */
@Service
@Transactional
public class CartServiceImpl implements ICartService {
    static final String SERVICEEXCEPTION = "ServiceException";
    static final Logger LOGGER = Logger.getLogger(CartServiceImpl.class);
    @Autowired
    private ICartDao cartDao;
    @Autowired
    private IProductsService productService;
    private Products product = new Products();

    @Override
    public void addToCart(Cart cart) throws DaoException {
        try {
            LOGGER.debug("Inside CartServiceImpl classs Inside addToCart Method");
            String pid = cart.getProductId();
            product = productService.getProducts(pid);
            cart.setQuantity(1);
            cart.setWeight(product.getWeight());
            cart.setPrice(product.getPrice());
            cartDao.addToCart(cart);
            LOGGER.debug("Added Succesfully");
        } catch (ResourceNotFound | DaoException e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new DaoException(SERVICEEXCEPTION + e);
        }
    }
@Override
    public void removeCart(String cartId) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside CartServiceImpl classs Inside removeCart Method");
            cartDao.removeCart(cartId);
            LOGGER.debug("Removed Cart");
        } catch (DaoException e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new ResourceNotFound(SERVICEEXCEPTION + e);
        }
    }

    @Override
    public List<CartProduct> getCartByUser(String userId) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside CartServiceImpl classs Inside getCartByUser Method");
            List<CartProduct> cartProductList = new ArrayList<>();
            List<Cart> carts;
            carts = cartDao.getCartByUser(userId);
            for (Cart cart : carts) {
                CartProduct cartProduct = new CartProduct();
                cartProduct.setCartId(cart.getCartId());
                cartProduct.setPrice(cart.getPrice());
                cartProduct.setQuantity(cart.getQuantity());
                String pid = cart.getProductId();
                product = productService.getProducts(pid);
                cartProduct.setProduct(product);
                cartProductList.add(cartProduct);
            }
            LOGGER.debug("Cart By User" + cartProductList);
            return cartProductList;
        } catch (DaoException | ResourceNotFound e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new ResourceNotFound(SERVICEEXCEPTION + e);
        }
    }

    @Override
    public void removeCartByUserId(String userId) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside CartServiceImpl classs Inside removeCartByUserId Method");
            cartDao.removeCartByUserId(userId);
            LOGGER.debug("Card Removed");
        } catch (DaoException e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new ResourceNotFound(SERVICEEXCEPTION + e);
        }

    }

    @Override
    public void addQuantityToCart(String cartId, String quantity) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside CartServiceImpl classs Inside addQuantityToCart Method");
            cartDao.addQuantityToCart(cartId, quantity);
            LOGGER.debug("Added Quantity to cart!");
        } catch (DaoException e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new ResourceNotFound(SERVICEEXCEPTION + e);
        }

    }
@Override
	public List<String> checkQuantity(String userId) {
		List<String> NA = new ArrayList<String>();
		 List<CartProduct> cartProductList = new ArrayList<>();
         List<Cart> carts;
         try {
			carts = cartDao.getCartByUser(userId);
			for (Cart cart : carts) {
				String pid = cart.getProductId();
				 try {
					product = productService.getProducts(pid);
					if(product.getQuantity()<cart.getQuantity()) {
					NA.add(product.getProductName());	
					}
				} catch (ResourceNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NA;
	}

}
