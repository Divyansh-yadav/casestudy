package com.impetus.ogos.vo;
/**
 *This class stores the details of the UpdateProductDetails.
 */
public class UpdateProductDetails {
    private String productId;
    private int quantity;
    private double price;
    private boolean isactive;
    private double weight;

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
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity is quantity of product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId is primary key of product
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
     * @return isactive
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * @param isactive is user active or not.
     */
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "UpdateProductDetails [productId=" + productId + ", quantity=" + quantity + ", price=" + price + ", isactive=" + isactive + ", weight="
                + weight + "]";
    }

}
