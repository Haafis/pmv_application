package com.pmv_application.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer userid;
    private String username;
    private String password;
    private String role;
}
