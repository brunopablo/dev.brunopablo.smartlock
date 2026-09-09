package dev.brunopablo.smartlocck.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemPurchaseRequest(
    @JsonProperty(value = "item_id") String itemId,
    @JsonProperty(value = "item_name") String itemName,
    @JsonProperty(value = "supplier_name") String supplierName,
    @JsonProperty(value = "supplier_email") String supplierEmail,
    @JsonProperty(value = "quantity") Integer quantity
) {}