package com.jp.web.Controller;

import com.jp.web.Model.Json;
import com.jp.web.Repository.postnumber;
import com.jp.web.Service.api;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api")
@RestController
public class APIController {

    @Autowired
    private api api;

    @PostMapping("post")
    public Object test(@ModelAttribute Json message) {
        String left = message.getLeft();
        String right = message.getRight();
        Optional<Json> t = api.test(left,right);
        return t;
    }

}
