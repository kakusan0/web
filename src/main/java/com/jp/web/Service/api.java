package com.jp.web.Service;

import com.jp.web.Model.Json;
import com.jp.web.Repository.postnumber;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class api {

    private postnumber postnumber;

    public Optional<Json> test(String t, String a){
        Json x = new Json();
        x.setLeft(t);
        x.setRight(a);
        Optional<Json> check = postnumber.findByLeftAndRight(x.getLeft(), x.getRight());
        return check;
    }

}