package com.projectlogstash.projeto_logstash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Projeto Logstash funcionando 🚀";
    }
}