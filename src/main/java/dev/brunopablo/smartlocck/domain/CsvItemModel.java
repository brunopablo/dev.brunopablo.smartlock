package dev.brunopablo.smartlocck.domain;

import com.opencsv.bean.CsvBindByName;

public class CsvItemModel {

    @CsvBindByName(column = "item_id")
    private String idItem;

    @CsvBindByName(column = "item_name")
    private String nameItem;

    @CsvBindByName(column = "quantity")
    private Integer quantity;

    @CsvBindByName(column = "reorder_threshold")
    private Integer reorderThreshold;

    @CsvBindByName(column = "supplier_name")
    private String nameSupplier;

    @CsvBindByName(column = "supplier_email")
    private String emailSupplier;

    @CsvBindByName(column = "last_stock_update_time")
    private String lastStockUpdateTime;

    public CsvItemModel() {
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getLastStockUpdateTime() {
        return lastStockUpdateTime;
    }

    public void setLastStockUpdateTime(String lastStockUpdateTime) {
        this.lastStockUpdateTime = lastStockUpdateTime;
    }
}