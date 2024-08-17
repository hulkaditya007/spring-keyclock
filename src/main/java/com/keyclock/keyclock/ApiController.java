package com.keyclock.keyclock;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/secured")
    public String securedEndpoint() {
        return "This is a secured endpoint. You need to be authenticated to access this.";
    }
}