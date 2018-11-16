package com.impetus.ogos.inventory.products.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.vo.UpdateProductDetails;

/**
 * Define the add ,get all Abstract method in this interface.
 */
@Service
public interface IProductsService {

	/**
	 * @param products taking the products as a input
	 * @throws DaoException If any exception occur in DaoClass.
	 */
	@Secured({ "ROLE_ADMIN" })
	void addProducts(Products products) throws DaoException;

	/**
	 * @param categoryId taking the categoryId as a input
	 * @return Return the List of products by category id
	 * @throws ResourceNotFound If products not found By category id
	 */
	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
	Products getProducts(String categoryId) throws ResourceNotFound;

	/**
	 * @param categoryId taking the categoryId as a input
	 * @return Return the List of products by productId
	 * @throws ResourceNotFound If products not found By category id
	 */
	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
	List<Products> findByCategory(String categoryId) throws ResourceNotFound;

	/**
	 * @return Return the List of All products
	 */
	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
	List<Products> getAllProducts();

	/**
	 * @param products taking the products as a input
	 * @throws DaoException If product not updated
	 */

	@Secured({ "ROLE_ADMIN" })
	void updateProductDetails(UpdateProductDetails products) throws DaoException;
}