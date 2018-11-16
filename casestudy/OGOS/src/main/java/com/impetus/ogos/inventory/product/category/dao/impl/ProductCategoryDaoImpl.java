package com.impetus.ogos.inventory.product.category.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.inventory.product.category.dao.IProductCategoryDao;
import com.impetus.ogos.inventory.product.category.model.ProductCategory;

/**It is implemented the ProductCategoryDao Interface and overriding the method.
 *
 */
@Repository
@Transactional
public class ProductCategoryDaoImpl implements IProductCategoryDao {
	static final String DAOEXCEPTION="DaoException";
	static final Logger LOGGER = Logger.getLogger(ProductCategoryDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addProductCategory(ProductCategory productCategory) throws DaoException {
		try {
			LOGGER.debug("Inside ProductCategoryDaoImpl class inside addProductCategory Method");
			entityManager.persist(productCategory);
			LOGGER.debug("Product Succesfully added!");
		} catch (Exception d) {
			LOGGER.error(DAOEXCEPTION + d);
			throw new DaoException(DAOEXCEPTION+ d);
		}
	}

	@Override
	public List<ProductCategory> getAllProductCategory() throws DaoException {
		try {
			LOGGER.debug("Inside ProductCategoryDaoImpl class inside getAllProductCategory Method");
			Query query = entityManager.createNamedQuery("get All Products");
			LOGGER.debug("All Product"+query.getMaxResults());
			@SuppressWarnings("unchecked")
			List<ProductCategory> productCategory= query.getResultList();
			return productCategory;
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION+e);
			throw new DaoException(DAOEXCEPTION+e);
		}
	}

	@Override
	public ProductCategory getProductCategoryById(String categoryId) throws DaoException {
		try {
			LOGGER.debug("Inside ProductCategoryDaoImpl class inside getProductCategoryById Method");
			return entityManager.find(ProductCategory.class, categoryId);
		} catch (Exception e) {
			LOGGER.error(DAOEXCEPTION+e);
			throw new DaoException(DAOEXCEPTION+e);
		}
	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {
		entityManager.merge(productCategory);
	}

}
