package com.impetus.ogos.inventory.products.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * It is the representation of Products table.
 *
 */
@Entity
@Table(name = "products")

@NamedQueries({
		@NamedQuery(query = "select p from Products p where p.categoryId = :categoryId", name = "findByCategory"),
		@NamedQuery(query = "select p from Products p ORDER BY p.creationtime DESC", name = "getAllProducts"),
		@NamedQuery(query = "Update Products set quantity = :quantity , price = :price , isactive = :isactive, weight = :weight where productId = :productId", name = "updateProductDetails") })
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8336461236309374292L;

	@Id
	@Column(name = "product_id")
	private String productId;

	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "weight")
	private double weight;

	@Column(name = "price")
	private double price;

	@Column(name = "isactive")
	private boolean isactive = true;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "creationtime")
	@CreationTimestamp
	private LocalDateTime creationtime;

	@Column(name = "modificationtime")
	@UpdateTimestamp
	private LocalDateTime modificationtime;

	/**
	 * It is generating the automatic key.
	 */
	public Products() {
		this.productId = UUID.randomUUID().toString();
	}

	/**
	 * Getter method for productId.
	 * 
	 * @return Return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Getter method for categoryId.
	 * 
	 * @return Return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Setter method for categoryId.
	 * 
	 * @param categoryId set the value of categoryId
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Getter method for productName.
	 * 
	 * @return Return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter method for productName.
	 * 
	 * @param productName set the value of productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter method for quantity.
	 * 
	 * @return Return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity.
	 * 
	 * @param quantity set the value of quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter method for weight.
	 * 
	 * @return Return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter method for Weight.
	 * 
	 * @param weight set the value of Weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Getter method for price.
	 * 
	 * @return Return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter method for price.
	 * 
	 * @param price set the value of price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter method for isactive.
	 * 
	 * @return Return the isactive
	 */
	public boolean isIsactive() {
		return isactive;
	}

	/**
	 * Setter method for isactive.
	 * 
	 * @param isactive set the value of isactive
	 */
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	/**
	 * Getter method for imageUrl.
	 * 
	 * @return Return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Setter method for imageUrl.
	 * 
	 * @param imageUrl set the value of imageUrl
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Getter method for creationtime.
	 * 
	 * @return Return the creationtime
	 */
	public LocalDateTime getCreationtime() {
		return creationtime;
	}

	/**
	 * Setter method for creationtime.
	 * 
	 * @param creationtime set the value of creationtime
	 */
	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}

	/**
	 * Getter method for modificationtime.
	 * 
	 * @return Return the modificationtime
	 */
	public LocalDateTime getModificationtime() {
		return modificationtime;
	}

	/**
	 * Setter method for modificationtime.
	 * 
	 * @param modificationtime set the value of modificationtime
	 */
	public void setModificationtime(LocalDateTime modificationtime) {
		this.modificationtime = modificationtime;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", quantity=" + quantity + ", weight=" + weight + ", price=" + price + ", isactive=" + isactive
				+ ", imageUrl=" + imageUrl + ", creationtime=" + creationtime + ", modificationtime=" + modificationtime
				+ "]";
	}

}