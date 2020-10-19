package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;
import java.time.LocalDateTime;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-14T17:03:29.621Z[GMT]")
@Controller
public class BookApiController implements BookApi {

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBook(@ApiParam(value = ""  )  @Valid @RequestBody Book body
) {
        System.out.println("\n\n\n tmp post debug");
        System.out.println(LocalDateTime.now());
        System.out.println("\n\n\n");
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBookById(@ApiParam(value = "The id of the book that needs to be deleted",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Book>> findBookByStatus(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, user, name, author") @Valid @RequestParam(value = "status", required = true) List<String> status
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Book>>(objectMapper.readValue("[ {\n  \"genreId\" : 2,\n  \"pageCount\" : 5,\n  \"isbn\" : 6,\n  \"name\" : \"name\",\n  \"coverTypeId\" : 5,\n  \"id\" : 0,\n  \"authorId\" : 1\n}, {\n  \"genreId\" : 2,\n  \"pageCount\" : 5,\n  \"isbn\" : 6,\n  \"name\" : \"name\",\n  \"coverTypeId\" : 5,\n  \"id\" : 0,\n  \"authorId\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "The id that needs to be fetched.",required=true) @PathVariable("id") String id
) {
        System.out.println("\n\n\n tmp get debug");
        System.out.println(LocalDateTime.now());
        System.out.println("\n\n\n");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"genreId\" : 2,\n  \"pageCount\" : 5,\n  \"isbn\" : 6,\n  \"name\" : \"name\",\n  \"coverTypeId\" : 5,\n  \"id\" : 0,\n  \"authorId\" : 1\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateBook(@ApiParam(value = ""  )  @Valid @RequestBody Book body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateBookById(@ApiParam(value = "id of book that need to be updated",required=true) @PathVariable("id") String id
,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
