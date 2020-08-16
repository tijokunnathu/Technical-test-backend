package com.westpac.tech.westpactechnicaltest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private UserCompany company;
}
