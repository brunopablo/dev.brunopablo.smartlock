package dev.brunopablo.smartlocck.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import dev.brunopablo.smartlocck.client.dto.ItemPurchaseRequest;
import dev.brunopablo.smartlocck.client.dto.ItemPurchaseResponse;

@FeignClient(name = "PurchaseClient", url = "${app.purchase.config.url}")
public interface PurchaseClient {

    @PostMapping(path = "/api/purchases")
    ResponseEntity<ItemPurchaseResponse> makePurchase(
        @RequestHeader("authorization") String token,
        @RequestBody ItemPurchaseRequest item
    );
}