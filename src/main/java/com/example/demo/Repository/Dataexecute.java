package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Datastorage;

@Repository
public interface Dataexecute extends JpaRepository<Datastorage, Integer> {
}
