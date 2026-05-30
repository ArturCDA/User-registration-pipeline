package com.projectlogstash.projeto_logstash.controller;

import com.projectlogstash.projeto_logstash.dto.UserRequestDTO;
import com.projectlogstash.projeto_logstash.entity.User;
import com.projectlogstash.projeto_logstash.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(
            @RequestBody UserRequestDTO dto
    ) {
        return service.createUser(dto);
    }
}