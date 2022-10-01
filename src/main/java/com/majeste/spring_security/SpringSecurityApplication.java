package com.majeste.spring_security;

import com.majeste.spring_security.entities.AppRoles;
import com.majeste.spring_security.entities.AppUser;
import com.majeste.spring_security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.addNewRole(new AppRoles(null, "USER"));
            accountService.addNewRole(new AppRoles(null, "ADMIN"));
            accountService.addNewRole(new AppRoles(null, "MANAGER"));

            accountService.addNewUser(new AppUser(null, "Siamois", "1234", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Majeste", "1234", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Cindy", "1234", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Talla", "1234", new ArrayList<>()));

            accountService.addRoleToUser("Siamois", "MANAGER");
            accountService.addRoleToUser("Majeste", "ADMIN");
            accountService.addRoleToUser("Cindy", "USER");
            accountService.addRoleToUser("Talla", "USER");
        };
    }
}
