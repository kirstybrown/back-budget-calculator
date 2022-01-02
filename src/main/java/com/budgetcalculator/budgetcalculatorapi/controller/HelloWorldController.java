package com.budgetcalculator.budgetcalculatorapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-world")
public class HelloWorldController {

    @GetMapping
    String hello() {
        return "Hello World!";
    }

}
