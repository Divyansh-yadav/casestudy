package com.impetus.ogos.inventory.product.category.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.impetus.ogos.inventory.products.model.Products;

/**It is the representation of ProductCategory table.
 *
 */
@Entity
@Table(name="product_category")
@NamedQuery(query="select p from ProductCategory p",name="get All Products")
public class ProductCategory implements Serializable{
	
	/**
	 * A unique serial version identifier.
	 */
	private static final long serialVersionUID = -2268566125515350159L;

	@Id
	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "creationtime")
	@CreationTimestamp
	private LocalDateTime creationtime;

	@Column(name = "modificationtime")
	@UpdateTimestamp
	private LocalDateTime modificationtime;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private List<Products> products;

	/**
	 * It is generating the automatic key.
	 */
	public ProductCategory() {
		this.categoryId = UUID.randomUUID().toString();
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
	 * Getter method for categoryId.
	 * 
	 * @return Return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Getter method for categoryName.
	 * 
	 * @return Return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Setter method for categoryName.
	 * 
	 * @param categoryName set the value of categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * Getter method for products.
	 * 
	 * @return Return the products
	 */
	public List<Products> getProducts() {
		return products;
	}

	/**
	 * Setter method for products.
	 * 
	 * @param products set the value of products
	 */
	public void setProducts(List<Products> products) {
		this.products = products;
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
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", imageUrl=" + imageUrl
				+ ", creationtime=" + creationtime + ", modificationtime=" + modificationtime + ", products=" + products
				+ "]";
	}

}
