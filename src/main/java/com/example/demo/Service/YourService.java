package com.example.demo.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.YourEntity;
import com.example.demo.Repository.YourRepository;

import jakarta.transaction.Transactional;

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
            fileWriter.append(entity.getUpdate_data());
            fileWriter.append(",");
            fileWriter.append("\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }
    
    @Transactional
    public void updateData2Column() {
        List<YourEntity> entities = yourRepository.findAll();
        for (YourEntity entity : entities) {
            String updateData = entity.getUpdate_data();
            String modifiedData = modifyData(updateData);
            entity.setUpdateData2(modifiedData);
        }
        yourRepository.saveAll(entities);
    }

    private String modifyData(String originalData) {
        if (originalData == null || originalData.length() != 6) {
            throw new IllegalArgumentException("Data must be 6 digits long");
        }
        String prefix = originalData.substring(0, 2);
        int prefixInt = Integer.parseInt(prefix);
        if (prefixInt >= 70 && prefixInt <= 99) {
            return "19" + originalData;
        } else if (prefixInt >= 20 && prefixInt <= 69) {
            return "20" + originalData;
        } else {
            throw new IllegalArgumentException("Data does not meet the criteria for modification");
        }
    }
}
