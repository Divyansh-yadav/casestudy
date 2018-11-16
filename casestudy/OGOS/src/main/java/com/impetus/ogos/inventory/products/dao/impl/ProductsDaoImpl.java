package com.impetus.ogos.inventory.products.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.inventory.products.dao.IProductsDao;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.vo.UpdateProductDetails;

/** It is implemented the IProductsDao and overriding the method. */
@Service
@Transactional
public class ProductsDaoImpl implements IProductsDao {
    static final String DAOEXCEPTION = "DaoException";
    static final Logger LOGGER = Logger.getLogger(ProductsDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProducts(Products products) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsDaoImpl Class Inside addProducts Method");
            entityManager.persist(products);
            entityManager.flush();
            LOGGER.info("Product SuccesFully Added!");
        } catch (Exception exception) {
            LOGGER.error("Products Dao Impl :: Add Products" + exception);
            throw new DaoException(exception.getMessage(), exception);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Products getProducts(String productId) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsDaoImpl Class Inside getProducts Method");
            return entityManager.find(Products.class, productId);
        } catch (NoResultException exception) {
            LOGGER.error("Products Dao Impl :: Get Products By Product Id" + exception);
            throw new DaoException(exception.getMessage(), exception);
        } catch (Exception exception) {
            LOGGER.error("Products Dao Impl :: Get Products By Product Id" + exception);
            throw new DaoException(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Products> findByCategory(String categoryId) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsDaoImpl Class Inside findByCategory Method");
            Query query = entityManager.createNamedQuery("findByCategory");
            query.setParameter("categoryId", categoryId);
            LOGGER.debug("Priducts By Category" + query.getResultList());
            @SuppressWarnings("unchecked")
            List<Products> products = query.getResultList();
            return products;
        } catch (NoResultException exception) {
            LOGGER.error("ProductsDaoImpl :: Get Category By Category ID " + exception);
            throw new DaoException(exception.getMessage(), exception);
        } catch (Exception exception) {
            LOGGER.error("ProductsDaoImpl :: Get Category By Category ID " + exception);
            throw new DaoException(exception.getMessage(), exception);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Products> getAllProducts() {
        Query query = entityManager.createNamedQuery("getAllProducts");
        @SuppressWarnings("unchecked")
        List<Products> products = query.getResultList();
        return products;
    }

    @Override
    public void updateProductDetails(UpdateProductDetails products) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsDaoImpl Class Inside updateProductDetails Method");
            int n = entityManager.createNamedQuery("updateProductDetails").setParameter("quantity", products.getQuantity())
                    .setParameter("price", products.getPrice()).setParameter("isactive", products.isIsactive())
                    .setParameter("productId", products.getProductId()).setParameter("weight", products.getWeight()).executeUpdate();
            LOGGER.debug("Update Product Details" + n + "Number of rows changed");
        } catch (Exception e) {
            LOGGER.error(DAOEXCEPTION + e);
            throw new DaoException(DAOEXCEPTION + e);
        }
    }

}
