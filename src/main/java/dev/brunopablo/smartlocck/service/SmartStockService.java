package dev.brunopablo.smartlocck.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.controller.dto.StartRequestDto;
import dev.brunopablo.smartlocck.domain.CsvItemModel;
import dev.brunopablo.smartlocck.entity.PurchaseItemRequestEntity;
import dev.brunopablo.smartlocck.repository.PurchaseItemRequestRepository;

@Service
public class SmartStockService {
    
    private final ReportService reportService;
    private final PurchaseService purchaseService;
    private final PurchaseItemRequestRepository purchaseItemRequestRepository;
    
    private final Double BUFFER_STOCK_MARGIN = 0.2;
    
    public SmartStockService(ReportService reportService, 
                             PurchaseService purchaseService,
                             PurchaseItemRequestRepository purchaseItemRequestRepository) {
        this.reportService = reportService;
        this.purchaseService = purchaseService;
        this.purchaseItemRequestRepository = purchaseItemRequestRepository;
    }
    
    public void process(StartRequestDto startData) {
        
        try{
            var csvItems = reportService.readReport(startData.reportPath());
            
            csvItems.forEach(
                item -> {
                    if (item.getQuantity() < item.getReorderThreshold()) {
                        var reorderQuantity = getReorderQuantity(item);
                        
                        var purchased = purchaseService.sendPurchaseRequest(item, reorderQuantity);
                        
                        persistItemStock(item, reorderQuantity, purchased);
                    }
                }
            );
            
        }catch(IOException e){
            throw new RuntimeException(e);
        };
    }
    
    private void persistItemStock(CsvItemModel item, Integer reorderQuantity, boolean purchased) {
        
        var itemPurchased = new PurchaseItemRequestEntity();
        
        itemPurchased.setItemId(item.getIdItem());
        itemPurchased.setItemName(item.getNameItem());
        itemPurchased.setQuantityOnStock(item.getQuantity());
        itemPurchased.setReorderThreshold(item.getReorderThreshold());
        itemPurchased.setSupplierName(item.getNameSupplier());
        itemPurchased.setSupplierEmail(item.getEmailSupplier());
        itemPurchased.setSupplierEmail(item.getLastStockUpdateTime());
        
        itemPurchased.setPurchaseQuantity(reorderQuantity);
        itemPurchased.setPurchaseWithSucess(purchased);
        itemPurchased.setPurchaseDateTime(LocalDateTime.now());
        
        purchaseItemRequestRepository.save(itemPurchased);
    }
    
    private Integer getReorderQuantity(CsvItemModel item) {
        
        return item.getReorderThreshold() + (
            (int) Math.ceil(item.getReorderThreshold() * BUFFER_STOCK_MARGIN)
        );
    }
}