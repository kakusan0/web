package com.example.demo.Model;

import java.io.Serializable;

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
@Table(name = "error")
public class NG implements Serializable {

	@Column(name = "id")
	int id;

	@Column(name = "text")
	String text;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id1")
	int id1;
}