package com.majeste.spring_security.repo;

import com.majeste.spring_security.entities.AppRoles;
import com.majeste.spring_security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRoles,Long> {
    AppRoles findByRoleName(String roleName);
}
