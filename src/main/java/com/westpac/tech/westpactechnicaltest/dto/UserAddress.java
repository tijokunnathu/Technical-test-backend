package com.westpac.tech.westpactechnicaltest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddress {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserGeographicalLocation geo;
}
