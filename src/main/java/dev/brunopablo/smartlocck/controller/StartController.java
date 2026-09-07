package dev.brunopablo.smartlocck.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.brunopablo.smartlocck.controller.dto.StartRequestDto;
import dev.brunopablo.smartlocck.service.StartService;

@RestController
@RequestMapping(path = "/start")
public class StartController {

    private final StartService startService;

    public StartController(StartService startService) {
        this.startService = startService;
    }

    @PostMapping
    public ResponseEntity<Void> start(@RequestBody StartRequestDto startData){

        startService.process(startData); 


        return ResponseEntity.accepted().build();
    }
}