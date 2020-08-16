package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.UsersDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void testMapUsers_whenSuccessScenario_thenValidUserDto() {

        UsersDto user = new UsersDto();
        user.setId(1);
        user.setName("name");
        UserMapper userMapper = new UserMapper(Arrays.asList(user));
        UsersDto usersDto = userMapper.mapUsers(1);
        Assert.assertEquals(1, (int) usersDto.getId());
        Assert.assertEquals("name", usersDto.getName());
    }
}