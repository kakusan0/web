package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Table(name = "sk_tmp_yusou")
@Data
@Entity
public class YourEntity {
    @Id
    private Long id;
    // その他のフィールド...
    @Column(name = "update_data")
    private String field1;
    // ゲッターとセッター...
}
