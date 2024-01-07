package com.jp.web.Controller;

import com.jp.web.Model.Json;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("api")
@RestController
public class APIController {
/*    @GetMapping("/住所")
    public List<Json> test(@RequestParam(name = "name",defaultValue = "") Optional<String> name) {
        long x =name.stream().count();
        return Arrays.asList(
                new Json(1, "Item1"),
                new Json(2, "Item2"),
                new Json(3, "Item3")
        );
    }*/

    @PostMapping("post")
    public List<Json> test(@RequestParam(name = "name") Optional<String> name) {
        long x =name.stream().count();
        return Arrays.asList(
                new Json(1, "Item1"),
                new Json(2, "Item2"),
                new Json(3, "Item3")
        );
    }
}
