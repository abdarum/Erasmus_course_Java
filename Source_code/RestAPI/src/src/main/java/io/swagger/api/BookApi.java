/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Book;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-30T16:20:30.954Z")

@Api(value = "book", description = "the book API")
@RequestMapping(value = "")
public interface BookApi {

    @ApiOperation(value = "Add a new book to the library", nickname = "addBook", notes = "", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Unauthorized, no access") })
    @RequestMapping(value = "/book",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addBook(@ApiParam(value = "order placed for purchasing the book" ,required=true )  @Valid @RequestBody Book body,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token);


    @ApiOperation(value = "Delete book", nickname = "deleteBookById", notes = "This can only be done by the logged in user.", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid id supplied"),
        @ApiResponse(code = 401, message = "Unauthorized, no access"),
        @ApiResponse(code = 404, message = "Book not found") })
    @RequestMapping(value = "/book/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBookById(@ApiParam(value = "The id of the book that needs to be deleted",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token);


    @ApiOperation(value = "Finds Books by status", nickname = "findBookByStatus", notes = "Multiple status values can be provided with comma separated strings", response = Book.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Book.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @RequestMapping(value = "/book/findByStatus",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Book>> findBookByStatus(@ApiParam(value = "Status values that need to be considered for filter", allowableValues = "available, all") @Valid @RequestParam(value = "status", required = false) List<String> status,@ApiParam(value = "Author of the book") @Valid @RequestParam(value = "author", required = false) String author,@ApiParam(value = "Title of the book") @Valid @RequestParam(value = "title", required = false) String title,@ApiParam(value = "Genere of the book") @Valid @RequestParam(value = "genere", required = false) String genere);


    @ApiOperation(value = "Get book by book id", nickname = "getBookById", notes = "", response = Book.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Book.class),
        @ApiResponse(code = 400, message = "Invalid id supplied"),
        @ApiResponse(code = 401, message = "Unauthorized, no access"),
        @ApiResponse(code = 404, message = "Book not found") })
    @RequestMapping(value = "/book/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Book> getBookById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token);


    @ApiOperation(value = "Updated book", nickname = "updateBookById", notes = "This can only be done by the logged in user.", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid id supplied"),
        @ApiResponse(code = 401, message = "Unauthorized, no access"),
        @ApiResponse(code = 404, message = "Book not found") })
    @RequestMapping(value = "/book/{id}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateBookById(@ApiParam(value = "id of book that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody Book body,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token);

}
