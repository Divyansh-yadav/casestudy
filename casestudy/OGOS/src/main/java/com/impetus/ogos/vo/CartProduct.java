package com.impetus.ogos.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impetus.ogos.inventory.products.model.Products;
/**
 *This class stores the details of the cart.
 */
public class CartProduct {

	private String cartId;

	private String userId;

	private String productId;

	private int quantity;

	private double weight;

	private double price;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private Products product;

	

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId is primary key of user.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId is primary key of service provider.
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return cartId
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * @param cartId is primary key of cart.
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity is quantity of product.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight is weight of product
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price is price of product
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return product
	 */
	public Products getProduct() {
		return product;
	}

	/**
	 * @param product is object of products.
	 */
	public void setProduct(Products product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "CartProduct [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", weight=" + weight + ", price=" + price + ", product=" + product + "]";
	}
}
