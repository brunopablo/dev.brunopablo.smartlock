package dev.brunopablo.smartlocck.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import dev.brunopablo.smartlocck.domain.CsvItemModel;

@Service
public class ReportService {

    public List<CsvItemModel> readReport(String reportPath) throws IOException{
        
        try(Reader reader = Files.newBufferedReader(Paths.get(reportPath))){

            return new CsvToBeanBuilder<CsvItemModel>(reader)
                .withType(CsvItemModel.class)
                .build()
                .parse();
        }
    }
}