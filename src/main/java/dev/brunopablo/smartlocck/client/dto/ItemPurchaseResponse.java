package dev.brunopablo.smartlocck.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemPurchaseResponse(
    @JsonProperty(value = "message") String message    
) {}