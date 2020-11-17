package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    
    @Autowired
    private UserService userService;


    public void run(ApplicationArguments args) {
        if(userService.countUserTypes() == 0){
            userService.initUserTypeValues();
        }
    }
}