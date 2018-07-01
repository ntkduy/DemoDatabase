package com.ntkduy1604.demodatabase.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.ntkduy1604.demodatabase.db.model.ListItemInterface;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Entity(tableName = "item_table")
public class ListItem implements ListItemInterface{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="item_id")
    private long itemId;

    @NonNull
    @ColumnInfo(name = "item_name")
    private String itemName;

    @NonNull
    @ColumnInfo(name = "item_price")
    private Double itemPrice;

    @NonNull
    @ColumnInfo(name = "item_qty")
    private Integer itemQty;

    @NonNull
    @ColumnInfo(name = "supplier_name")
    private String supplierName;

    @NonNull
    @ColumnInfo(name = "supplier_phone")
    private String supplierPhone;

    public ListItem(long itemId, @NonNull String itemName, @NonNull Double itemPrice, @NonNull Integer itemQty, @NonNull String supplierName, @NonNull String supplierPhone) {
        this.setItemId(itemId);
        this.setItemName(itemName);
        this.setItemPrice(itemPrice);
        this.setItemQty(itemQty);
        this.setSupplierName(supplierName);
        this.setSupplierPhone(supplierPhone);
    }

    // Getter
    @Override
    public long getItemId() {
        return itemId;
    }

    @NonNull
    @Override
    public String getItemName() {
        return itemName;
    }

    @NonNull
    @Override
    public Double getItemPrice() {
        return itemPrice;
    }

    @NonNull
    @Override
    public Integer getItemQty() {
        return itemQty;
    }

    @NonNull
    @Override
    public String getSupplierName() {
        return supplierName;
    }

    @NonNull
    @Override
    public String getSupplierPhone() {
        return supplierPhone;
    }

    // Setter

    @Override
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public void setItemName(@NonNull String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public void setItemQty(@NonNull Integer itemQty) {
        this.itemQty = itemQty;
    }

    @Override
    public void setSupplierName(@NonNull String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public void setSupplierPhone(@NonNull String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
}
