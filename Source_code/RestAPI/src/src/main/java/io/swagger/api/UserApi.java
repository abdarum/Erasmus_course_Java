/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.User;
import io.swagger.model.UserStatus;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")

@Api(value = "user", description = "the user API")
@RequestMapping(value = "")
public interface UserApi {

    @ApiOperation(value = "Create user", nickname = "createUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Bad request") })
    @RequestMapping(value = "/user",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body);


    @ApiOperation(value = "Delete user", nickname = "deleteUserById", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Id supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUserById(@ApiParam(value = "The Id that needs to be deleted",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Get user statistics by user name", nickname = "getStatsById", notes = "", response = UserStatus.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserStatus.class),
        @ApiResponse(code = 400, message = "Invalid Id supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{id}/stats",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserStatus> getStatsById(@ApiParam(value = "",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Get user by id", nickname = "getUserById", notes = "", response = User.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid id supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Logs user into the system", nickname = "loginUser", notes = "", response = User.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(value = "/user/login",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<User> loginUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody Body body);


    @ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user/logout",
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutUser();


    @ApiOperation(value = "Updated user", nickname = "updateUserById", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid Id supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{id}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUserById(@ApiParam(value = "Id that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body);

}
