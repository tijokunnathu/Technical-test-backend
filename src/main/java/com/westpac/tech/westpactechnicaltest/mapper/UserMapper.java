package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.UsersDto;

import java.util.List;

public class UserMapper {

private List<UsersDto> usersList;

    public UserMapper(List<UsersDto> usersList) {
        this.usersList = usersList;
    }
    public UsersDto mapUsers(Integer id){

        return usersList.stream().filter(usersDto ->
                usersDto.getId().equals(id)).findAny().orElse(null);

    }
}
