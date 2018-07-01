package com.ntkduy1604.demodatabase.db.model;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
public interface ListItemInterface {
    // Item ID
    long getItemId();
    void setItemId(long itemId);

    // Item Name
    String getItemName();
    void setItemName(String itemName);

    // Item Price
    Double getItemPrice();
    void setItemPrice(double itemPrice);

    // Item Qty
    Integer getItemQty();
    void setItemQty(Integer itemQty);

    // Supplier Name
    String getSupplierName();
    void setSupplierName(String supplierName);

    // Supplier Phone
    String getSupplierPhone();
    void setSupplierPhone(String supplierPhone);

}
