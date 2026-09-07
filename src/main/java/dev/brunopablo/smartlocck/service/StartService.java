package dev.brunopablo.smartlocck.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import dev.brunopablo.smartlocck.controller.dto.StartRequestDto;

@Service
public class StartService {

    private final ReportService reportService;

	public StartService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void process(StartRequestDto startData) {
		
        try{
            var csvItems = reportService.readReport(startData.reportPath());

        }catch(IOException e){
            throw new RuntimeException(e);
        };
	}
}