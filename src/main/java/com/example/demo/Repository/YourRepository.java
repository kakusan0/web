package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.YourEntity;

public interface YourRepository extends JpaRepository<YourEntity, Long> {
}
