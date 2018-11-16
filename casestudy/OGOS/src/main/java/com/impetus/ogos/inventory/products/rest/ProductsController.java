package com.impetus.ogos.inventory.products.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.exception.RestException;
import com.impetus.ogos.exception.URIPathException;
import com.impetus.ogos.inventory.products.model.Products;
import com.impetus.ogos.inventory.products.service.IProductsService;
import com.impetus.ogos.vo.UpdateProductDetails;

/** ProductsController is handling the action of Products. */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductsController {
	static final Logger LOGGER = Logger.getLogger(ProductsController.class);
	@Autowired
	private IProductsService productsService;

	/**
	 * It is calling the addProducts method of IProductsService.
	 * 
	 * @param products taking the products as a input
	 * @return Return the Created Status.
	 * @throws DaoException If any exception occur in DaoClass.
	 */
	@PostMapping("addProducts")
	public ResponseEntity<Products> addProducts(@RequestBody Products products) throws DaoException {
		if (products != null) {
			try {
				LOGGER.debug("Inside ProductsController Class Inside addProducts Method");
				productsService.addProducts(products);
				LOGGER.debug("Product Succesfully Added" + products);
				return new ResponseEntity<>(products, HttpStatus.CREATED);
			} catch (RestException exception) {
				LOGGER.error("Products Controller :: Add Products", exception);
				throw new RestException("Product Cannot be Added", exception);
			}
		} else {
			throw new URIPathException("Product Details be Empty");
		}
	}

	/**
	 * It is calling the findByCategory method of IProductsService.
	 * 
	 * @param categoryId taking the categoryId as a input
	 * @return Return the List of products by category id
	 * @throws ResourceNotFound If products not found By category id
	 */
	@GetMapping("getByCategory/{category_id}")
	public ResponseEntity<List<Products>> getByCategory(@PathVariable("category_id") String categoryId)
			throws ResourceNotFound {
		List<Products> products;
		if (categoryId != null) {
			try {
				LOGGER.debug("Inside ProductsController Class Inside getByCategory Method");
				products = productsService.findByCategory(categoryId);
				LOGGER.debug("Products" + products);
				return new ResponseEntity<>(products, HttpStatus.OK);
			} catch (ResourceNotFound e) {
				LOGGER.error("Product Not Found By category" + e);
				throw new ResourceNotFound("Product Not Found By category" + e);
			}
		} else {
			throw new URIPathException("Category Id Cannot be Null");
		}
	}

	/**
	 * It is calling the getProducts method of IProductsService.
	 * 
	 * @param productId taking the productId as a input
	 * @return Return the List of products by productId
	 * @throws ResourceNotFound If products not found By category id
	 */
	@GetMapping("getProduct/{productId}")
	public ResponseEntity<Products> getProduct(@PathVariable("productId") String productId) throws ResourceNotFound {
		Products products;
		if (productId != null) {
			try {
				LOGGER.debug("Inside ProductsController Class Inside getProduct Method");
				products = productsService.getProducts(productId);
				LOGGER.debug("Products" + products);
				return new ResponseEntity<>(products, HttpStatus.OK);
			} catch (ResourceNotFound r) {
				LOGGER.error("Product Not Found" + r);
				throw new ResourceNotFound("Product Not Found" + r);
			} catch (RestException exception) {
				throw new RestException("Products Not Found ");
			}
		} else {
			throw new URIPathException("Product ID Cannot be null");
		}
	}

	/**
	 * It is calling the getAllProducts method of IProductsService.
	 * 
	 * @return Return the List of All products
	 */
	@GetMapping("getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts() {
		List<Products> products = productsService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	/**
	 * It is calling the updateProductDetails method of IProductsService.
	 * 
	 * @param products taking the products as a input
	 * @throws DaoException If product not updated
	 */
	@PostMapping("updateProductDetails")
	public void updateProductDetails(@RequestBody UpdateProductDetails products) throws DaoException {

		try {
			LOGGER.debug("Inside ProductsController Class Inside updateProductDetails Method");
			LOGGER.debug("Updating product Details:" + products);
			productsService.updateProductDetails(products);
			LOGGER.info("updated products Details");
		} catch (DaoException e) {
			LOGGER.error("Products details not updated" + e);
			throw new DaoException("Not Updated" + e);
		}
	}
}
