package com.example.demo.Repository;

import com.example.demo.Model.userstorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface jpaRepository extends JpaRepository<userstorage, Long> {
    Optional<userstorage> findByuser(String user);
}
