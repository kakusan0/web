package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.mailstorage;

@Repository
public interface findmail extends JpaRepository<mailstorage, String> {
}
