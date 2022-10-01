package com.majeste.spring_security.web;

import com.majeste.spring_security.entities.AppRoles;
import com.majeste.spring_security.entities.AppUser;
import com.majeste.spring_security.service.AccountService;
import com.majeste.spring_security.web.dto.AddRoleToUserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/users")
    public List<AppUser> appUsers() {
        return accountService.findAllUsers();
    }

    @PostMapping(path = "/create-user")
    AppUser saveUser(@RequestBody AppUser user) {
        return accountService.addNewUser(user);
    }

    @PostMapping(path = "/create-role")
    AppRoles saveRole(@RequestBody AppRoles roles) {
        return accountService.addNewRole(roles);
    }

    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody AddRoleToUserDto dto) {
        accountService.addRoleToUser(dto.getUserName(), dto.getRoleName());
    }
}