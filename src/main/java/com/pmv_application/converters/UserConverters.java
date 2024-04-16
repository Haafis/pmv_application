package com.pmv_application.converters;

import com.pmv_application.model.dao.UserDao;
import com.pmv_application.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverters {
    public static UserDao toUserDao(UserDto userDto) {
        UserDao userDao = new UserDao();
        userDao.setUserid(userDto.getUserid());
        userDao.setUsername(userDto.getUsername());
        userDao.setPassword(userDto.getPassword());
        userDao.setRole(userDto.getRole());
        return userDao;
    }
    public UserDto toUserDto(UserDao userDao) {
        UserDto userDto = new UserDto();
        userDto.setUserid(userDao.getUserid());
        userDto.setUsername(userDao.getUsername());
        userDto.setPassword(userDao.getPassword());
        userDto.setRole(userDao.getRole());
        return userDto;
    }
}
