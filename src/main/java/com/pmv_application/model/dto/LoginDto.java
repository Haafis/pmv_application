package com.pmv_application.model.dto;

import lombok.Data;

@Data
public class LoginDto {
    private  String loginUsername;
    private String loginPassword;
    private String loginuserRole;
}
