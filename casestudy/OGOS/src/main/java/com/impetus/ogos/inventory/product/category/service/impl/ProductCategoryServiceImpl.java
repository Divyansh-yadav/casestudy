package com.impetus.ogos.inventory.product.category.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.product.category.dao.IProductCategoryDao;
import com.impetus.ogos.inventory.product.category.dao.impl.ProductCategoryDaoImpl;
import com.impetus.ogos.inventory.product.category.model.ProductCategory;
import com.impetus.ogos.inventory.product.category.service.ProductCategoryService;

/**
 * Implemented the IProductCategoryService and overriding the method.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	static final Logger LOGGER = Logger.getLogger(ProductCategoryDaoImpl.class);
	static final String SERVICEEXCEPTION = "ServiceException";
	@Autowired
	private IProductCategoryDao productCategoryDao;

	@Override
	public void addProductCategory(ProductCategory productCategory) throws DaoException {
		try {
			LOGGER.debug("Inside ProductCategoryServiceImpl class inside addProductCategory Method");
			productCategoryDao.addProductCategory(productCategory);
			LOGGER.debug("Product Succesfully added!");
		} catch (DaoException d) {
			LOGGER.error(SERVICEEXCEPTION + d);
			throw new DaoException(SERVICEEXCEPTION + d);
		}
	}

	@Override
	public List<ProductCategory> getProductCategory() throws ResourceNotFound {
		List<ProductCategory> categories;
		try {
			LOGGER.debug("Inside ProductCategoryServiceImpl class inside getProductCategory Method");
			categories = productCategoryDao.getAllProductCategory();
			LOGGER.debug("All Product Category" + categories);
			return categories;
		} catch (DaoException d) {
			LOGGER.error(SERVICEEXCEPTION + d);
			throw new ResourceNotFound(SERVICEEXCEPTION + d);
		}

	}

	@Override
	public ProductCategory getProductCategoryById(String categoryId) throws ResourceNotFound {
		ProductCategory productCategory;
		try {
			LOGGER.debug("Inside ProductCategoryServiceImpl class inside getProductCategoryById Method");
			productCategory = productCategoryDao.getProductCategoryById(categoryId);
			LOGGER.debug("Product Category By Id" + productCategory);
			return productCategory;
		} catch (DaoException d) {
			LOGGER.error(SERVICEEXCEPTION + d);
			throw new ResourceNotFound(SERVICEEXCEPTION + d);
		}

	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {
		productCategoryDao.updateProductCategory(productCategory);
	}
}
