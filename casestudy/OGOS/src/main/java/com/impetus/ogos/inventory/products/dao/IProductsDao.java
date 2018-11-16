package com.impetus.ogos.inventory.products.dao;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.vo.UpdateProductDetails;
/**
 *It is performing the save,find and update operation from database.
 */
@Service
public interface IProductsDao {	
	/**
	 * Add the product in database.
	 * @param products taking the products as a input
	 * @throws DaoException if any exception occur in daoclass
	 */
	void addProducts(Products products) throws DaoException;

	/**
	 * Abstract method of getAllProducts.
	 * @return Return the getAllProducts
	 */
	@Secured({ "ROLE_ADMIN" })
	List<Products> getAllProducts();

	/** find the product by category id.
	 * @param categoryId taking the categoryId as a input
	 * @return Return the ptoduct by category Id
	 * @throws DaoException if any exception occur in daoclass
	 */
	List<Products> findByCategory(String categoryId) throws DaoException;

	/**get product by productid.
	 * @param productId taking the productId as a input
	 * @return Return the ptoduct by productId
	 * @throws DaoException if any exception occur in daoclass
	 */
	Products getProducts(String productId) throws DaoException;

	/**Update Products.
	 * @param products  taking the products as a input
	 * @throws DaoException if any exception occur in daoclass
	 */
	void updateProductDetails(UpdateProductDetails products) throws DaoException;
}
