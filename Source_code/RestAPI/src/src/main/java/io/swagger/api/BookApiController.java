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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.time.LocalDateTime;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-30T15:30:33.697Z")

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

    public ResponseEntity<Void> addBook(@ApiParam(value = "order placed for purchasing the book" ,required=true )  @Valid @RequestBody Book body,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(bookService.isModifyBookPermittedForToken(body, token)){
                bookService.createBook(body);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> deleteBookById(@ApiParam(value = "The id of the book that needs to be deleted",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(bookService.isModifyBookPermittedForToken(id, token)){
                Book book = bookService.deleteBookById(id);
                if (book != null) {
                    return new ResponseEntity<Void>(HttpStatus.OK);
                } else { 
                    return ResponseEntity.notFound().build();
                }
            }
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        } 
        else 
        {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Book>> findBookByStatus(@ApiParam(value = "Status values that need to be considered for filter", allowableValues = "available, all") @Valid @RequestParam(value = "status", required = false) List<String> status,@ApiParam(value = "Author of the book") @Valid @RequestParam(value = "author", required = false) String author,@ApiParam(value = "Title of the book") @Valid @RequestParam(value = "title", required = false) String title,@ApiParam(value = "Genere of the book") @Valid @RequestParam(value = "genere", required = false) String genere) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<Book> books = bookService.findBookByStatus("status", author, title, genere);
            return ResponseEntity.ok(books);
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
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

    public ResponseEntity<Void> updateBookById(@ApiParam(value = "id of book that need to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody Book body,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(bookService.isModifyBookPermittedForToken(id, token)){
                Book book = bookService.updateBookById(id, body);
                if (book != null) {
                    return new ResponseEntity<Void>(HttpStatus.OK);
                } else { 
                    return ResponseEntity.notFound().build();
                }
            }
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

}
