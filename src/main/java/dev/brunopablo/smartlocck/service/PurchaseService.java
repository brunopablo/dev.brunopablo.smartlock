package dev.brunopablo.smartlocck.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.client.PurchaseClient;
import dev.brunopablo.smartlocck.client.dto.ItemPurchaseRequest;
import dev.brunopablo.smartlocck.domain.CsvItemModel;

@Service
public class PurchaseService {

    private final Logger logger = LoggerFactory.getLogger(PurchaseService.class);
    private final AuthService authService;
    private final PurchaseClient purchaseClient;

    public PurchaseService(AuthService authService, PurchaseClient purchaseClient) {
        this.authService = authService;
        this.purchaseClient = purchaseClient;
    }

    public boolean sendPurchaseRequest(CsvItemModel item, Integer reorderQuantity){

        // fazer autenticacao
        var token = authService.getToken();

        // enviar pedido
        var purchaseResponse = purchaseClient.makePurchase(
            token,
            new ItemPurchaseRequest(
                item.getIdItem(),
                item.getNameItem(),
                item.getNameSupplier(),
                item.getEmailSupplier(),
                reorderQuantity
            )
        );

        if (!purchaseResponse.getStatusCode().is2xxSuccessful()) {
            logger.error(
                "Unsuccessful request. THe purchase was not completed. Info: Status {}, Response " + purchaseResponse.getStatusCode().value(), purchaseResponse.getBody()
            );

            return false;
        }

        return true;
    }
}