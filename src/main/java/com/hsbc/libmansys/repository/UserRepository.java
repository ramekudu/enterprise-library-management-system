package com.hsbc.libmansys.repository;

import com.hsbc.libmansys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
