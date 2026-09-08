package dev.brunopablo.smartlocck.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.brunopablo.smartlocck.client.dto.AuthRequest;
import dev.brunopablo.smartlocck.client.dto.AuthResponse;

@FeignClient(name = "AuthClient", url = "${app.config.url}")
public interface AuthClient {

    @PostMapping(path = "/api/token")
    ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest);
}