package com.example.demo.Model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Component
@Data
@Table(name = "userstorage")
public class userstorage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "mail")
	String mail;

	@Column(name = "password")
	String pw;

	@Column(name = "NG_flag")
	Integer NG_flag;

	@Column(name = "NG_date")
	Date NG_date;
}