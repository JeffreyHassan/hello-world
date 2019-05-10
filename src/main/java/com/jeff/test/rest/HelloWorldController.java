package com.jeff.test.rest;

import com.jeff.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping("/")
    public ResponseEntity<String> helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok("Hello World!");
    }

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok(helloWorldService.helloWorld(name));
    }
}
