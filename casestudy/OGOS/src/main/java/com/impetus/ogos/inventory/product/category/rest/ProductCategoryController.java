package com.impetus.ogos.inventory.product.category.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.inventory.product.category.model.ProductCategory;
import com.impetus.ogos.inventory.product.category.service.impl.ProductCategoryServiceImpl;

/**
 * The ProductCategoryController handling the ProductCategory Action.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

	static final Logger LOGGER = Logger.getLogger(ProductCategoryController.class);
	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;

	/**
	 * This method Adding the ProductCategory.
	 * 
	 * @param productCategory taking the ProductCategory as a input
	 * @return Return the Created Status.
	 */
	@PostMapping("addProductCategory")
	public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
		try {
			LOGGER.debug("Inside ProductCategoryController class inside addProductCategory Method");
			productCategoryServiceImpl.addProductCategory(productCategory);
			LOGGER.debug("Product Succesfully added!" + productCategory);
			return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
		} catch (DaoException e) {
			LOGGER.error("Controller Exception" + e);
			return null;
		}

	}
	/**This method fetches the all ProductCategory.
	 * @return Return the List of All ProductCategody 
	 * @throws ResourceNotFound If productCategory not found
	 */
	@GetMapping("getProductCategory")
	public ResponseEntity<List<ProductCategory>> getProductCategory() throws ResourceNotFound {
		List<ProductCategory> categories;
		try {
			LOGGER.debug("Inside ProductCategoryController class inside getProductCategory Method");
			categories = productCategoryServiceImpl.getProductCategory();
			LOGGER.debug("Get Product Category" + categories);
			return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (ResourceNotFound r) {
			LOGGER.error("Product Not FOund");
			throw new ResourceNotFound("Resource Not Found" + r);
		}

	}
	/**This method fetches the ProductCategory by category id.
	 * @param categoryId taking the categoryId as a input
	 * @return Return the List of ProductCategody by category id 
	 * @throws ResourceNotFound If productCategory not found By category id
	 */
	@GetMapping("getProductCategoryById/{category_id}")
	public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable("category_id") String categoryId)
			throws ResourceNotFound {
		ProductCategory productCategory = null;
		try {
			LOGGER.debug("Inside ProductCategoryController class inside getProductCategoryById Method");
			productCategory = productCategoryServiceImpl.getProductCategoryById(categoryId);
			LOGGER.debug("All Product Category By Id" + productCategory);
			return new ResponseEntity<>(productCategory, HttpStatus.OK);
		} catch (ResourceNotFound r) {
			LOGGER.error("Product Not Found" + r);
			throw new ResourceNotFound("Product Not Found" + r);
		}

	}
	/**It is calling the updateProductCategory method of IProductCategoryService.
	 * @param productCategory Taking the productCategory as a input
	 * @return Return the Created Status. 
	 */
	@PutMapping("updateProductCategory")
	public ResponseEntity<ProductCategory> updateProductCategory(@RequestBody ProductCategory productCategory) {
		LOGGER.debug(
				"control goes from Rest Product Category(updateProductCategory) to Service Product Category(updateProductCategory) ");
		productCategory.setCategoryId("7d3748b1-e678-4507-8831-4327e2af1b4c");
		productCategoryServiceImpl.updateProductCategory(productCategory);
		LOGGER.info("Updated Product Category");
		return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
	}
}
