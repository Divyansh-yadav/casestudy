package com.impetus.ogos.ordermanagment.cart.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *It is the representation of Cart table.
 */
@Entity
@Table(name="cart")
@NamedQuery(query="Select c from Cart c where c.userId = :userId ", name = "findCartByUser")
@NamedQuery(query="Delete  from Cart  where userId = :userId ", name = "deleteCartByUser")
@NamedQuery(query = "Update Cart set quantity = :quantity where cartId = :cartId", name = "addQuantityToCart")
public class Cart {

	@Id
    @Column(name = "cart_id")
    private String cartId; 
	
	/**
	 * It is generating the automatic key.
	 */
	public Cart() {
        this.cartId = UUID.randomUUID().toString();
    }
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="product_id")
	private String productId;
	
	@Column
	private int quantity;
	
	@Column
	private double weight;
	
	@Column 
	
	private double price;
	
	/**
	 * Getter method for userId.
	 * 
	 * @return Return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * Setter method for userId.
	 * 
	 * @param userId set the value of userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * Setter method for productId.
	 * 
	 * @param productId set the value of productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name="creationtime")
    @CreationTimestamp
    private LocalDateTime creationtime;
	/**
	 * Getter method for cartId.
	 * 
	 * @return Return the cartId
	 */
    public String getCartId() {
		return cartId;
	}

    /**
	 * Setter method for cartId.
	 * 
	 * @param cartId set the value of cartId
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
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
	 * Setter method for weight.
	 * 
	 * @param weight set the value of weight
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

	@Column(name="modificationtime")
    @UpdateTimestamp
    private LocalDateTime modificationtime;

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
        return "cart [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", creationtime="
                + creationtime + ", modificationtime=" + modificationtime + "]";
    }

}