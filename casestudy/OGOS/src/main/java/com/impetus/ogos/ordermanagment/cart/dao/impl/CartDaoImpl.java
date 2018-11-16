package com.impetus.ogos.ordermanagment.cart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.ordermanagment.cart.dao.ICartDao;
import com.impetus.ogos.ordermanagment.cart.model.Cart;
/**
 *It is implemented the ICartDao and overriding the method.
 */
@Repository
public class CartDaoImpl implements ICartDao {
    static final String DAOEXCEPTION = "DaoException";

    static final Logger LOGGER = Logger.getLogger(CartDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addToCart(Cart cart) throws DaoException {
        try {
            LOGGER.debug("Inside CartDaoImpl classs Inside addToCart Method");
            entityManager.persist(cart);
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException(DAOEXCEPTION + e);
        }
    }

    @Override
    public List<Cart> getCartByUser(String userId) throws DaoException {
        try {
            LOGGER.debug("Inside CartDaoImpl classs Inside getCartByUser Method");

            Query query = entityManager.createNamedQuery("findCartByUser");
            query.setParameter("userId", userId);
            @SuppressWarnings("unchecked")
            List<Cart> carts = query.getResultList();
            LOGGER.debug("Carts By User" + carts);
            return carts;
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException(DAOEXCEPTION + e);
        }
    }

    @Override
   
    public void removeCartByUserId(String userId) throws DaoException {
        try {
            LOGGER.debug("Inside CartDaoImpl classs Inside removeCartByUserId Method");
            Query query = entityManager.createNamedQuery("deleteCartByUser");
            query.setParameter("userId", userId);
            int row = query.executeUpdate();
            LOGGER.debug("Updated Row" + row);
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException(DAOEXCEPTION + e);
        }
    }

    @Override
    public void removeCart(String cartId) throws DaoException {
        try {
            LOGGER.debug("Inside CartDaoImpl classs Inside removeCart Method");
            Cart cart = entityManager.find(Cart.class, cartId);
            entityManager.remove(cart);
            LOGGER.debug("Cart Removed!");
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException(DAOEXCEPTION + e);
        }
    }

    @Override
    public void addQuantityToCart(String cartId, String quantity) throws DaoException {
        try {
            LOGGER.debug(cartId+"    "+quantity);
            LOGGER.debug("Inside CartDaoImpl classs Inside addQuantityToCart Method");
            int row = entityManager.createNamedQuery("addQuantityToCart")
                    .setParameter("quantity", Integer.parseInt(quantity))
                    .setParameter("cartId", cartId).executeUpdate();
            LOGGER.debug("Update Row" + row);
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException();
        }
    }

}
