package com.example.medifacts_app;

public class CartItemModel {
    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT=1;
    private int type;
    //cart item
    private int productImage;
    private String productTitle;
    private int freeCoupons;
    private String productPrice;
    private String cuttedPrice;
    private int productQty;
    private int offersapplied;
    private int coupons_applied;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static int getCartItem() {
        return CART_ITEM;
    }

    public static int getTotalAmount() {
        return TOTAL_AMOUNT;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCoupons() {
        return freeCoupons;
    }

    public void setFreeCoupons(int freeCoupons) {
        this.freeCoupons = freeCoupons;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getOffersapplied() {
        return offersapplied;
    }

    public void setOffersapplied(int offersapplied) {
        this.offersapplied = offersapplied;
    }

    public int getCoupons_applied() {
        return coupons_applied;
    }

    public void setCoupons_applied(int coupons_applied) {
        this.coupons_applied = coupons_applied;
    }

    public CartItemModel(int type, int productImage, String productTitle, int freeCoupons, String productPrice, String cuttedPrice, int productQty, int offersapplied, int coupons_applied) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupons = freeCoupons;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQty = productQty;
        this.offersapplied = offersapplied;
        this.coupons_applied = coupons_applied;
    }
//cart item

    //cartTotal
    private String totalItems;
    private String totalItemPrice;
    private String deliveryPrice;
    private String savedAmount;
    private String totalAmmount;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }

    public void setTotalAmmount(String totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public String getTotalAmmount() {
        return totalAmmount;
    }

    public CartItemModel(int type, String totalItems, String totalItemPrice, String deliveryPrice, String savedAmount, String totalAmmount) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemPrice = totalItemPrice;
        this.deliveryPrice = deliveryPrice;
        this.savedAmount = savedAmount;
        this.totalAmmount = totalAmmount;
    }
}
