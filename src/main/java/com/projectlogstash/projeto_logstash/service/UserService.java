package com.projectlogstash.projeto_logstash.service;

import com.projectlogstash.projeto_logstash.dto.UserRequestDTO;
import com.projectlogstash.projeto_logstash.entity.User;
import com.projectlogstash.projeto_logstash.logs.LogProducer;
import com.projectlogstash.projeto_logstash.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final LogProducer logProducer;

    public UserService(UserRepository repository,
                       LogProducer logProducer) {
        this.repository = repository;
        this.logProducer = logProducer;
    }

    public User createUser(UserRequestDTO dto) {

        User user = new User(
                dto.getName(),
                dto.getEmail()
        );

        User savedUser = repository.save(user);

        logProducer.logUserCreated(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );

        return savedUser;
    }
}