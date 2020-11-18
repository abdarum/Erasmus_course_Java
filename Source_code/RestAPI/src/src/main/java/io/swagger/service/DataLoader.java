package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public void run(ApplicationArguments args) {
        if(userService.countUserTypes() == 0){
            userService.initUserTypeValues();
        }
        if(userService.countUsers() == 0){
            userService.initUserValues();
        }

        if(bookService.countAuthors() == 0){
            bookService.initAuthorValues();
        }
        if(bookService.countBookGenres() == 0){
            bookService.initBookGenreValues();
        }
        if(bookService.countCoverTypes() == 0){
            bookService.initCoverTypeValues();
        }
        if(bookService.countBooks() == 0){
            bookService.initBookValues();
        }
    }
}