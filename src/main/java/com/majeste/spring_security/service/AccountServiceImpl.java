package com.majeste.spring_security.service;

import com.majeste.spring_security.entities.AppRoles;
import com.majeste.spring_security.entities.AppUser;
import com.majeste.spring_security.repo.RoleRepository;
import com.majeste.spring_security.repo.UserRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser user) {
        String pwd = user.getPassword();
        user.setPassword(passwordEncoder.encode(pwd));
        return userRepository.save(user);
    }

    @Override
    public AppUser getUser(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public AppRoles addNewRole(AppRoles role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser user = userRepository.findByUsername(userName);
        AppRoles role = roleRepository.findByRoleName(roleName);
        user.getAppRoles().add(role);
    }

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }
}
