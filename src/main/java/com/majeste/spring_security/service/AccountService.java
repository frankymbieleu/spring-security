package com.majeste.spring_security.service;

import com.majeste.spring_security.entities.AppRoles;
import com.majeste.spring_security.entities.AppUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AppUser addNewUser(AppUser user);

    AppUser getUser(String userName);

    AppRoles addNewRole(AppRoles role);

    void addRoleToUser(String userName, String roleName);
    @PostAuthorize("hasAuthority('ADMIN')")
    List<AppUser> findAllUsers();

}
