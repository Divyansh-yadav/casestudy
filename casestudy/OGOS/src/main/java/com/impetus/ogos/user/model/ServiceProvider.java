package com.impetus.ogos.user.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.impetus.ogos.ordermanagment.orderdetail.model.OrderDetails;

/** This class contains the details of the service provider who delivers the product to the customer. */

@Entity
@Table(name = "service_provider")
@NamedQuery(query = "select s from ServiceProvider s where s.providerid =:providerid", name = "getDetailsByProviderId")
public class ServiceProvider {
    @Id
    @Column(name = "provider_pk")
    private String providerid;

    /** It is generating the automatic key. */
    public ServiceProvider() {
        this.providerid = UUID.randomUUID().toString();
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private CustomerDetail customerDetail;

    @OneToOne
    @JoinColumn(name = "service_provider_id", referencedColumnName = "user_id")
    private User serviceProviderId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderDetails orderId;

    @Column(name = "delivery_status")
    private String deliveryStatus = "placed";

    @Column(name = "creationtime")
    @CreationTimestamp
    private LocalDateTime creationtime;

    @Column(name = "modificationtime")
    @UpdateTimestamp
    private LocalDateTime modificationtime;

    /** @return customerDetail */
    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    /** @param customerDetail
     *            is set the value of customerDetail */
    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    /** @return providerid */
    public String getProviderid() {
        return providerid;
    }

    /** Setter method for providerid.
     * 
     * @param providerid
     *            set the value of providerid */
    public void setProviderid(String providerid) {
        this.providerid = providerid;
    }

    /** Getter method for serviceProviderId.
     * 
     * @return Return the serviceProviderId */
    public User getServiceProviderId() {
        return serviceProviderId;
    }

    /** Setter method for serviceProviderId.
     * 
     * @param serviceProviderId
     *            set the value of serviceProviderId */
    public void setServiceProviderId(User serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    /** Getter method for userId.
     * 
     * @return Return the userId */
    public User getUserId() {
        return userId;
    }

    /** Setter method for userId.
     * 
     * @param userId
     *            set the value of userId */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /** Getter method for orderId.
     * 
     * @return Return the orderId */

    public OrderDetails getOrderId() {
        return orderId;
    }

    /** Setter method for orderId.
     * 
     * @param orderId
     *            set the value of orderId */
    public void setOrderId(OrderDetails orderId) {
        this.orderId = orderId;
    }

    /** Getter method for deliveryStatus.
     * 
     * @return Return the deliveryStatus */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /** Setter method for deliveryStatus.
     * 
     * @param deliveryStatus
     *            set the value of deliveryStatus */
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /** Getter method for creationtime.
     * 
     * @return Return the creationtime */

    public LocalDateTime getCreationtime() {
        return creationtime;
    }

    /** Setter method for creationtime.
     * 
     * @param creationtime
     *            set the value of creationtime */
    public void setCreationtime(LocalDateTime creationtime) {
        this.creationtime = creationtime;
    }

    /** Getter method for modificationtime.
     * 
     * @return Return the modificationtime */
    public LocalDateTime getModificationtime() {
        return modificationtime;
    }

    /** Setter method for modificationtime.
     * 
     * @param modificationtime
     *            set the value of modificationtime */
    public void setModificationtime(LocalDateTime modificationtime) {
        this.modificationtime = modificationtime;
    }

    @Override
    public String toString() {
        return "ServiceProvider [providerid=" + providerid + ", customerDetail=" + customerDetail + ", serviceProviderId=" + serviceProviderId
                + ", userId=" + userId + ", orderId=" + orderId + ", deliveryStatus=" + deliveryStatus + ", creationtime=" + creationtime
                + ", modificationtime=" + modificationtime + "]";
    }

}