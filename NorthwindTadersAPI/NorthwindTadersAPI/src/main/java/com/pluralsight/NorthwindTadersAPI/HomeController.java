package com.pluralsight.NorthwindTadersAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/home")
    public String homePage(@RequestParam(defaultValue = "world") String country){
        return "hello " + country;
    }
}
