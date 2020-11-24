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

    @Autowired
    private LibraryService libraryService;

    public void run(ApplicationArguments args) {
        // User
        if(userService.countUserTypes() == 0){
            userService.initUserTypeValues();
        }
        if(userService.countUsers() == 0){
            userService.initUserValues();
        }
        
        // Book
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
        
        // Library
        if(libraryService.countBorrowPlaces() == 0){
            libraryService.initBorrowPlaceValues();
        }
        if(libraryService.countBorrowPeriods() == 0){
            libraryService.initBorrowPeriodValues();
        }

        if(libraryService.countBorrowed() == 0){
            libraryService.initBorrowedValues();
        }
    }
}