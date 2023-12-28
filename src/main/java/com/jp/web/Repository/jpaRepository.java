package com.jp.web.Repository;

import com.jp.web.Model.userstorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface jpaRepository extends JpaRepository<userstorage, Long> {
    Optional<userstorage> findByUserAndPw(String user, String pw);
}
