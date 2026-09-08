package dev.brunopablo.smartlocck.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.controller.dto.StartRequestDto;
import dev.brunopablo.smartlocck.domain.CsvItemModel;

@Service
public class SmartStockService {

    private final ReportService reportService;
    private final PurchaseService purchaseService;

    private final Double BUFFER_STOCK_MARGIN = 0.2;

	public SmartStockService(ReportService reportService, PurchaseService purchaseService) {
        this.reportService = reportService;
        this.purchaseService = purchaseService;
    }

    public void process(StartRequestDto startData) {
		
        try{
            var csvItems = reportService.readReport(startData.reportPath());

            csvItems.forEach(
                item -> {
                    if (item.getQuantity() < item.getReorderThreshold()) {
                        var reorderQuantity = getReorderQuantity(item);

                        // chamar service de compras
                        purchaseService.sendPurchaseRequest(item, reorderQuantity);
                    }
                }
            );

        }catch(IOException e){
            throw new RuntimeException(e);
        };
	}

    private Integer getReorderQuantity(CsvItemModel item) {
        
        return item.getReorderThreshold() + (
            (int) Math.ceil(item.getReorderThreshold() * BUFFER_STOCK_MARGIN)
        );
    }
}