package com.ditjhaba.spring.spike.service;

import com.ditjhaba.spring.spike.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
