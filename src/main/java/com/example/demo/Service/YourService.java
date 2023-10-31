package com.example.demo.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.YourEntity;
import com.example.demo.Repository.YourRepository;

@Service
public class YourService {
    @Autowired
    private YourRepository yourRepository;

    public void exportToCSV(String filename) throws IOException {
        List<YourEntity> entities = yourRepository.findAll();
        FileWriter fileWriter = new FileWriter(filename);

        // CSVヘッダーの書き込み
        fileWriter.append("Column1, Column2, Column3...\n");

        // データの書き込み
        for (YourEntity entity : entities) {
            fileWriter.append(entity.getField1());
            fileWriter.append(",");
            fileWriter.append("\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
