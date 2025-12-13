package com.incubyte.sweetshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SweetController {

    @GetMapping("/sweets")
    public String getAllSweets() {
        return "Sweet list accessed successfully";
    }
}
