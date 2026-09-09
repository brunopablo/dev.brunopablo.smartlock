package dev.brunopablo.smartlocck.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "doc_purchase_requests")
public class PurchaseItemRequestEntity {

    @MongoId
    @Field(name = "id_item")
    private String itemId;
    
    @Field(name = "name_item")
    private String itemName;
    
    @Field(name = "quantity_on_stock")
    private Integer quantityOnStock;
    
    @Field(name = "reorder_threshold")
    private Integer reorderThreshold;
    
    @Field(name = "name_supplier")
    private String supplierName;

    @Field(name = "email_supplier")
    private String supplierEmail;
    
    @Field(name = "last_stock_update_time")
    private LocalDateTime lastStockUpdateTime;
    
    @Field(name = "purchase_quantity")
    private Integer purchaseQuantity;
    
    @Field(name = "purchase_with_sucess")
    private boolean purchaseWithSucess;
    
    @Field(name = "purchase_date_time")
    private LocalDateTime purchaseDateTime;

    public PurchaseItemRequestEntity() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Integer quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public LocalDateTime getLastStockUpdateTime() {
        return lastStockUpdateTime;
    }

    public void setLastStockUpdateTime(LocalDateTime lastStockUpdateTime) {
        this.lastStockUpdateTime = lastStockUpdateTime;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public boolean isPurchaseWithSucess() {
        return purchaseWithSucess;
    }

    public void setPurchaseWithSucess(boolean purchaseWithSucess) {
        this.purchaseWithSucess = purchaseWithSucess;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }
}