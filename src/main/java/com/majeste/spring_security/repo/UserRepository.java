package com.majeste.spring_security.repo;

import com.majeste.spring_security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String userName);
}
