package com.pmv_application.controller;

import com.pmv_application.model.dto.LoginDto;
import com.pmv_application.model.dto.UserDto;
import com.pmv_application.repository.UserRepository;
import com.pmv_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/SignUp")
    public String signUp(@RequestBody  UserDto userDto) {
        try {
            String username = userDto.getUsername();
            String password = userDto.getPassword();
            String role = userDto.getRole();
            userService.SaveSignup(userDto);
            return "SignUp Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        try {
            String loginUsername = loginDto.getLoginUsername();
            String loginPassword = loginDto.getLoginPassword();
            String loginRole = loginDto.getLoginuserRole();
            List<Object[]> userNameAndPassword = userRepository.getLoginUsernameAndPassword(loginRole);

            if (!userNameAndPassword.isEmpty()) {
                Object[] user = userNameAndPassword.get(0);
                String username = (String) user[0];
                String password = (String) user[1];
                String role = (String) user[2];
                if (username.equals(loginUsername) && password.equals(loginPassword)) {
                    System.out.println("Login SuccessfulL");
                    return ResponseEntity.ok().body(role);
                } else {
                    System.out.println("Incorrect Username or Password.");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password.");
                }
            } else {
                System.out.println("No results found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No results found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
