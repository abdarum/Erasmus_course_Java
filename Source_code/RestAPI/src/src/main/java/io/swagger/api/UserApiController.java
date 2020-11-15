package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.User;
import io.swagger.model.UserStatus;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")

@Controller
public class UserApiController implements UserApi {
	@Autowired
    private UserService userService;
    

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            userService.createUser(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "The Id that needs to be deleted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.getUserById(id);
            if (user != null) {
                userService.deleteUserById(id);
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

    public ResponseEntity<UserStatus> getStatsById(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserStatus>(objectMapper.readValue("{  \"numberOfCurrentBorrowedBooks\" : 1,  \"numberOfAllBorrowedBooks\" : 0,  \"numberOfAllDamagedBooks\" : 6,  \"numberOfDelayedBooks\" : 5}", UserStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> getUserById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
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

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateUserById(@ApiParam(value = "Id that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            User user = userService.getUserById(id);
            if (user != null) {
                userService.updateUserById(id, body);
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
