package com.moon.domain.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String userAccount;
    private String pwd;
    private String checkPwd;
}
