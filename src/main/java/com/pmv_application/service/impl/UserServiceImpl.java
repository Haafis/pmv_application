package com.pmv_application.service.impl;

import com.pmv_application.converters.UserConverters;
import com.pmv_application.model.dao.UserDao;
import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.UserDto;
import com.pmv_application.repository.UserRepository;
import com.pmv_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserConverters userConverters;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void SaveSignup(UserDto userDto) {
        UserDao userDao = userConverters.toUserDao(userDto);
        userRepository.save(userDao);

    }
}
