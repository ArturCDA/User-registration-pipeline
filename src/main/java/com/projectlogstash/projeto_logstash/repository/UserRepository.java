package com.projectlogstash.projeto_logstash.repository;

import com.projectlogstash.projeto_logstash.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}