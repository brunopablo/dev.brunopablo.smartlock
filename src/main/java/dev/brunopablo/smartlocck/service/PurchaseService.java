package dev.brunopablo.smartlocck.service;

import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.domain.CsvItemModel;

@Service
public class PurchaseService {

    private final AuthService authService;

    public PurchaseService(AuthService authService) {
        this.authService = authService;
    }

    public void sendPurchaseRequest(CsvItemModel item, Integer reorderQuantity){

        // fazer autenticacao
        var token = authService.getToken();
    }
}