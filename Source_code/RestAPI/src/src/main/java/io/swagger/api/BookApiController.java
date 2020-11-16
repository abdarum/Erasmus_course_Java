package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.model.User;
import io.swagger.service.BookService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.time.LocalDateTime;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")

@Controller
public class BookApiController implements BookApi {
	@Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBook(@ApiParam(value = "order placed for purchasing the pet" ,required=true )  @Valid @RequestBody Book body) {
        System.out.println(LocalDateTime.now());
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            bookService.createBook(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> deleteBookById(@ApiParam(value = "The id of the book that needs to be deleted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            Book book = bookService.deleteBookById(id);
            if (book != null) {
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

    public ResponseEntity<List<Book>> findBookByStatus(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, user, name, author") @Valid @RequestParam(value = "status", required = true) List<String> status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {  \"genreId\" : 2,  \"pageCount\" : 5,  \"isbn\" : 6,  \"name\" : \"name\",  \"coverTypeId\" : 5,  \"id\" : 0,  \"authorId\" : 1}, {  \"genreId\" : 2,  \"pageCount\" : 5,  \"isbn\" : 6,  \"name\" : \"name\",  \"coverTypeId\" : 5,  \"id\" : 0,  \"authorId\" : 1} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id) {
        
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            Book book = bookService.getBookById(id);
            if (book != null) {
                return ResponseEntity.ok(book);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> updateBookById(@ApiParam(value = "id of book that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            Book book = bookService.updateBookById(id, body);
            if (book != null) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

}
