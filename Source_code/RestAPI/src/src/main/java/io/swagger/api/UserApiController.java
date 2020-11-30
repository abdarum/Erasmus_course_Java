package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.Borrowed;
import io.swagger.model.User;
import io.swagger.model.UserStatus;
import io.swagger.service.LibraryService;
import io.swagger.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-30T15:30:33.697Z")

@Controller
public class UserApiController implements UserApi {
	@Autowired
    private UserService userService;
    
    @Autowired
    private LibraryService libraryService;
    
    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body,@ApiParam(value = "") @Valid @RequestParam(value = "token", required = false) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(userService.createUser(body) != null){
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "The Id that needs to be deleted",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.deleteUserById(id);
            if (user != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else { 
                return ResponseEntity.notFound().build();
            }
        } 
        else 
        {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UserStatus> getStatsById(@ApiParam(value = "",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.getUserById(id);
            if (user != null) {
                List<Borrowed> allBorrowed = libraryService.getAllBorrowedByUser(Long.valueOf(id));
                List<Borrowed> damagedBorrowed = libraryService.getAllDamagedBorrowedBooksByList( allBorrowed );
                List<Borrowed> currentBorrowed = libraryService.getAllCurrentBorrowedBooksByList( allBorrowed );
                List<Borrowed> delayedBorrowed = libraryService.getAllDelayedBorrowedBooksByList( allBorrowed );
                
                UserStatus status = new UserStatus();
                status.setNumberOfAllBorrowedBooks(allBorrowed.size());
                status.setNumberOfAllDamagedBooks(damagedBorrowed.size());
                status.setNumberOfCurrentBorrowedBooks(currentBorrowed.size());
                status.setNumberOfDelayedBooks(delayedBorrowed.size());
                return ResponseEntity.ok(status);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<UserStatus>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<User> getUserById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<User> loginUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody Body body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{  \"userTypeId\" : 6,  \"lastName\" : \"lastName\",  \"birthdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"gender\" : \"gender\",  \"city\" : \"city\",  \"registrated\" : \"2000-01-23T04:56:07.000+00:00\",  \"adress\" : \"adress\",  \"firstName\" : \"firstName\",  \"password\" : \"password\",  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"status\" : \"active\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> logoutUser(@ApiParam(value = "") @Valid @RequestParam(value = "token", required = false) String token) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateUserById(@ApiParam(value = "Id that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.updateUserById(id, body);
            if (user != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

}
