package com.jeff.test.service.impl;

import com.jeff.test.service.HelloWorldService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"sit","uat","prod"})
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String helloWorld(String input) {
        return "Hello " + input;
    }
}
