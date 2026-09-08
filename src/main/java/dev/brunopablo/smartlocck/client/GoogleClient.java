package dev.brunopablo.smartlocck.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GoogleClient", url = "http://google.com")
public interface GoogleClient {

    @GetMapping
    ResponseEntity<String> helloGoogle();
}