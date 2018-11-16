package com.impetus.ogos.inventory.products.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.exception.RestException;
import com.impetus.ogos.inventory.products.dao.IProductsDao;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.inventory.products.service.IProductsService;
import com.impetus.ogos.vo.UpdateProductDetails;

/** Implemented the IProductsService and overriding the method. */
@Service
public class ProductsServiceImpl implements IProductsService {
    static final Logger LOGGER = Logger.getLogger(ProductsServiceImpl.class);
    static final String SERVICEEXCEPTION = "ServiceException";
    @Autowired
    private IProductsDao productsDao;

    @Override
    public void addProducts(Products products) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsServiceImpl Class Inside addProducts Method");
            productsDao.addProducts(products);
            LOGGER.info("Product SuccesFully Added!");
        } catch (DaoException exception) {
            LOGGER.error(SERVICEEXCEPTION + exception);
            throw new RestException(exception.getMessage(), exception);
        }
    }

    @Override
    public Products getProducts(String productId) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside ProductsServiceImpl Class Inside getProducts Method");
            return productsDao.getProducts(productId);
        } catch (DaoException exception) {
            if (exception.getCause() instanceof NoResultException)
                throw new ResourceNotFound("NO Product Found For Corresponding Product ID" + exception);
        }
        throw new RestException("Unable To Get Product");
    }

    @Override
    public List<Products> findByCategory(String categoryId) throws ResourceNotFound {
        try {
            LOGGER.debug("Inside ProductsServiceImpl Class Inside findByCategory Method");
            return productsDao.findByCategory(categoryId);
        } catch (DaoException exception) {
            if (exception.getCause() instanceof NoResultException)
                throw new ResourceNotFound("NO Products Found For Corresponding Category Id :" + categoryId);
        }
        throw new RestException("Unable To Get Products For Corresponding Category Id");
    }

    @Override
    public List<Products> getAllProducts() {
        return productsDao.getAllProducts();
    }

    @Override
    public void updateProductDetails(UpdateProductDetails products) throws DaoException {
        try {
            LOGGER.debug("Inside ProductsServiceImpl Class Inside updateProductDetails Method");
            productsDao.updateProductDetails(products);
            LOGGER.debug("Updated Products");
        } catch (DaoException e) {
            LOGGER.error(SERVICEEXCEPTION + e);
            throw new DaoException(SERVICEEXCEPTION + e);
        }
    }

}
