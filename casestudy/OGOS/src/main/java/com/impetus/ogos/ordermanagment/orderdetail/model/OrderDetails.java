package com.impetus.ogos.ordermanagment.orderdetail.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impetus.ogos.user.model.User;

/** This class stores the detail of the order placed by customer.
 * 
 */
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {

    /**
     * A unique id.
     */
    private static final long serialVersionUID = 7978459088841419114L;

    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * It is generating the automatic key.
     */
    public OrderDetails() {
        this.orderId = UUID.randomUUID().toString();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
   private  User user;

    @Transient
    private String userId;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "total_weight")
    private double totalWeight;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "product_detail")
    @JsonProperty
    private String productDetail;
    @Column(name = "creationtime")
    @CreationTimestamp
    private LocalDateTime creationtime;

    @Column(name = "modificationtime")
    @UpdateTimestamp
    private LocalDateTime modificationtime;

    /**
	 * Getter method for orderId.
	 * 
	 * @return Return the orderId
	 */
    public String getOrderId() {
        return orderId;
    }
    /**
	 * Getter method for user.
	 * 
	 * @return Return the user
	 */
    public User getUser() {
        return user;
    }
    /**
	 * Setter method for user.
	 * 
	 * @param user set the value of user
	 */
    public void setUser(User user) {
        this.user = user;
    }
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
   	 * Getter method for totalAmount.
   	 * 
   	 * @return Return the totalAmount
   	 */
    public double getTotalAmount() {
        return totalAmount;
    }
    /**
	 * Setter method for totalAmount.
	 * 
	 * @param totalAmount set the value of totalAmount
	 */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    /**
   	 * Getter method for totalWeight.
   	 * 
   	 * @return Return the totalWeight
   	 */
    public double getTotalWeight() {
        return totalWeight;
    }
    /**
	 * Setter method for totalWeight.
	 * 
	 * @param totalWeight set the value of totalWeight
	 */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    /**
   	 * Getter method for totalQuantity.
   	 * 
   	 * @return Return the totalQuantity
   	 */
    public int getTotalQuantity() {
        return totalQuantity;
    }
    /**
	 * Setter method for totalQuantity.
	 * 
	 * @param totalQuantity set the value of totalQuantity
	 */
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    /**
   	 * Getter method for productDetail.
   	 * 
   	 * @return Return the productDetail
   	 */
    public String getProductDetail() {

        return productDetail;
    }
    /**
   	 * Setter method for productDetail.
   	 * 
   	 * @param productDetail set the value of productDetail
   	 */
    public void setProductDetail(String productDetail) {
                this.productDetail = productDetail;
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
        return "OrderDetails [orderId=" + orderId + ", user=" + user + ", userId=" + userId + ", totalAmount=" + totalAmount + ", totalWeight="
                + totalWeight + ", totalQuantity=" + totalQuantity + ", productDetail=" + productDetail + ", creationtime=" + creationtime
                + ", modificationtime=" + modificationtime + "]";
    }

}