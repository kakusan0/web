package com.jp.web.Controller;

import com.jp.web.Model.Json;
import com.jp.web.Repository.postnumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api")
@RestController
public class APIController {
    @Autowired
    private postnumber postnumber;
    @PostMapping("post")
    public boolean test(@ModelAttribute Json message) {
        Optional<Json> check = postnumber.findByPostcodeleftAndPostcoderight(message.getPostcodeleft(), message.getPostcoderight());
        return check.isEmpty();
    }

}
