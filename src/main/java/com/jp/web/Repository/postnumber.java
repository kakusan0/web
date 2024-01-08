package com.jp.web.Repository;

import com.jp.web.Model.Json;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface postnumber extends JpaRepository<Json, String> {


    Optional<Json> findByPostcodeleftAndPostcoderight(String postcodeleft, String postcoderight);
}
