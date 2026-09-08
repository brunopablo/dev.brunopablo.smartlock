package dev.brunopablo.smartlocck.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthRequest(
    @JsonProperty(value = "grant_type") String grantType,
    @JsonProperty(value = "client_id") String clientId,
    @JsonProperty(value = "client_secret") String clientSecret
) {}