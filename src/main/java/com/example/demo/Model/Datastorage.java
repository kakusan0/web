package com.example.demo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//テーブルであることを証明
@Entity
//テーブルを設定
@Table(name = "spring")
//set get を設定
@Data
public class Datastorage implements Serializable {
	@Id
	//@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String mail;
	private String pw;
}