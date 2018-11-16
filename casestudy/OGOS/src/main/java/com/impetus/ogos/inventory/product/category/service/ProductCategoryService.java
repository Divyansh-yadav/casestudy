package com.impetus.ogos.inventory.product.category.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.product.category.model.ProductCategory;

/**
 * Define the add ,get all Abstract method in this interface.
 */
@Service
public interface ProductCategoryService {

	/**
	 * AddProductCategory Abstract Method.
	 * 
	 * @param productCategory taking the ProductCategory as a input
	 * @throws DaoException if any exception occur in Dao class
	 */

	@Secured({ "ROLE_ADMIN" })
	void addProductCategory(ProductCategory productCategory) throws DaoException;

	/**
	 * Get All ProductCategory.
	 * 
	 * @return Return the all getProductCategory.
	 * @throws ResourceNotFound If ProductCategory not found
	 */

	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
	List<ProductCategory> getProductCategory() throws ResourceNotFound;

	/**
	 * Get ProductCategory By Id.
	 * 
	 * @param categoryId taking the categoryId as a input
	 * @return Return the List of ProductCategody by category id
	 * @throws ResourceNotFound If productCategory not found By category id
	 */

	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
	ProductCategory getProductCategoryById(String categoryId) throws ResourceNotFound;

	/**
	 * @param productCategory taking the ProductCategory as a input
	 */

	@Secured({ "ROLE_ADMIN" })
	void updateProductCategory(ProductCategory productCategory);
}
