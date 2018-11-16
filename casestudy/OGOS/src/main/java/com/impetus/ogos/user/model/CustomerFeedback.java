package com.impetus.ogos.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;
/**
 *This class stores the details of the CustomerFeedback.
 */
@Entity
@Table(name="customer_feedback")
@NamedQuery(name="updateFeedback",query="update CustomerFeedback c set c.feedback = :feedback, c.comments = :comments where c.user = :user and c.orderDetails = :orderDetails")
public class CustomerFeedback implements Serializable{

	/**
     * A unique Id.
     */
    private static final long serialVersionUID = -4515599469314259376L;

    @Id
    @Column(name="feedback_id")
    private String feedbackId;
    
    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderDetails orderDetails;
    
    @Transient
    private String orderId;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @Transient
    private String userId;
    
    @Column(name="feedback")
    private String feedback;
    
    @Column(name="comments")
    private String comments;
    
    @Column(name = "creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private  Date creationtime;

    @Column(name = "modificationtime")
    @UpdateTimestamp
    private LocalDateTime modificationtime;
    /**
   	 * No args constructor. This constructor generates the unique id for each
   	 * CustomerFeedback.
   	 */
    public CustomerFeedback() {
        this.feedbackId = UUID.randomUUID().toString();
    }
    
    
    /**
     * @return orderId
     */
    public String getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId is primary key of order.
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


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
	 * @return feedbackId
	 */
	public String getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId is primary key of customer feedback
     */
    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback is feedback of order.
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments is comments of order.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return creationtime
     */
    public Date getCreationtime() {
        return creationtime;
    }

    /**
	 * Setter method for creationtime.
	 * 
	 * @param creationtime set the value of creationtime
	 */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    /**
     * @return modificationtime
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

    /**
     * @return orderDetails
     */
    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails is order details object
     */
    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user is object of user.
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "CustomerFeedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", comments=" + comments + ", creationtime=" + creationtime
                + ", modificationtime=" + modificationtime + ", orderDetails=" + orderDetails + ", user=" + user + "]";
    }

}