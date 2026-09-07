package dev.brunopablo.smartlocck.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.brunopablo.smartlocck.controller.dto.StartRequestDto;
import dev.brunopablo.smartlocck.service.SmartStockService;

@RestController
@RequestMapping(path = "/smartstock")
public class StartController {

    private final SmartStockService startService;

    public StartController(SmartStockService startService) {
        this.startService = startService;
    }

    @PostMapping(path = "/start")
    public ResponseEntity<Void> start(@RequestBody StartRequestDto startData){

        CompletableFuture.runAsync(
            () -> startService.process(startData)
        );

        return ResponseEntity.accepted().build();
    }
}