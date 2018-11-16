package com.impetus.ogos.ordermanagment.orderdetail.model;

import org.json.JSONArray;
/**
 *This class stores the detail of the Products. 
 *
 */
public class ProductDetails {

	private double totalAmount;
    
    private String userId;
    
    private double totalWeight;

    private int totalQuantity;

    private JSONArray productDetail;
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
   	 * Getter method for productDetail.
   	 * 
   	 * @return Return the productDetail
   	 */
    public String getProductDetails() {
        return productDetail.toString();
    }
    /**
	 * Setter method for productDetail.
	 * 
	 * @param productDetail set the value of productDetail
	 */
    public void setProductDetails(JSONArray productDetail) {
        this.productDetail = productDetail;
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

}