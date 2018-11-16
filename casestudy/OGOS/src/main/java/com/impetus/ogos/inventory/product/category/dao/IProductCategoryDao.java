package com.impetus.ogos.inventory.product.category.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.inventory.product.category.model.ProductCategory;

/**ProductCategoryDao Interface which is providing following method. 
 *
 */
@Repository
public interface IProductCategoryDao {
	//@Secured({"admin"})
	/**Add the product CAtegory in database.
	 * @param productCategory Object of ProductCategory 
	 * @throws DaoException throw the DaoException
	 */
	void addProductCategory(ProductCategory productCategory) throws DaoException;
	
	//@Secured({"customer"})
	/**Get all ProductCAtegory from database.
	 * @return Return the ProductCategory list
	 * @throws DaoException throw DaoException
	 */
	List<ProductCategory> getAllProductCategory() throws DaoException;
	
	/**Get the productCategory by CategoryId.
	 * @param categoryId It is primary key of ProductCAtegory
	 * @return Return the row of corresponding key
	 * @throws DaoException throw DaoException
	 */
	ProductCategory getProductCategoryById(String categoryId) throws DaoException;
	
	//@Secured({"admin"})
	/**Upadate the ProductCategory.
	 * @param productCategory Get the ProductCategory Object 
	 */
	void updateProductCategory(ProductCategory productCategory);
}

