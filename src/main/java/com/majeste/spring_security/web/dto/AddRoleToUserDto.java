package com.majeste.spring_security.web.dto;

import lombok.Data;

@Data
public class AddRoleToUserDto {
    private String userName;
    private String roleName;
}
