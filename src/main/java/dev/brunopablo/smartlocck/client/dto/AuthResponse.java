package dev.brunopablo.smartlocck.client.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthResponse(
    @JsonProperty(value = "access_token") String acessToken,
    @JsonProperty(value = "expires_in") Integer expiresIn
) {}