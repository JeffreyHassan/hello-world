package com.jeff.test.service.impl;

import com.jeff.test.service.HelloWorldService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class HelloWorldDevService implements HelloWorldService {
    @Override
    public String helloWorld(String input) {
        return "(DEV) Hello " + input;
    }
}
