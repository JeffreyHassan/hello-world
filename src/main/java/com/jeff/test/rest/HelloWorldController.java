package com.jeff.test.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jeff on 5/10/2019.
 */
@RestController
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok(name);
    }
}
