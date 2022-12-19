package com.github.mhmdd9.oauth2sample.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping("/public")
    public String getHome() {
        return "home";
    }

    @GetMapping("/private")
    public String getPrivateHome() {
        return "private home";
    }
}
