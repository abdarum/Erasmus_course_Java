package io.swagger.api;

import io.swagger.model.Author;
import io.swagger.model.BookGenre;
import io.swagger.model.BorrowPeriod;
import io.swagger.model.BorrowPlace;
import io.swagger.model.CoverType;
import io.swagger.service.BookService;
import io.swagger.service.LibraryService;
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
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-10T16:58:49.916Z")

@Controller
public class DatasetApiController implements DatasetApi {

    private static final Logger log = LoggerFactory.getLogger(DatasetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;
    
    @org.springframework.beans.factory.annotation.Autowired
    public DatasetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Author>> getDatasetAuthors(@ApiParam(value = "The id of the author. If not entered then all authors are listed") @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<Author> authors = new ArrayList();
            if(id == null){
                authors = bookService.getAllAuthors();
            } else {
                Author author = bookService.getAuthorById(id);
                if(author != null){
                    authors.add(author);
                }
            }
            return ResponseEntity.ok(authors);
        }

        return new ResponseEntity<List<Author>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<BookGenre>> getDatasetBookGenre(@ApiParam(value = "The id of the book genre. If not entered then all book genre are listed") @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<BookGenre> bookGenres = new ArrayList();
            if(id == null){
                bookGenres = bookService.getAllBookGenres();
                return ResponseEntity.ok(bookGenres);
            }
        }

        return new ResponseEntity<List<BookGenre>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<BorrowPeriod>> getDatasetBorrowPeriod(@ApiParam(value = "The id of the borrow period. If not entered then all borrow period are listed") @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<BorrowPeriod> borrowPeriods = new ArrayList();
            if(id == null){
                borrowPeriods = libraryService.getAllBorrowPeriods();
                return ResponseEntity.ok(borrowPeriods);
            }
        }

        return new ResponseEntity<List<BorrowPeriod>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<BorrowPlace>> getDatasetBorrowPlace(@ApiParam(value = "The id of the borrow place. If not entered then all borrow place are listed") @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<BorrowPlace> borrowPlaces = new ArrayList();
            if(id == null){
                borrowPlaces = libraryService.getAllBorrowPlaces();
                return ResponseEntity.ok(borrowPlaces);
            }
        }

        return new ResponseEntity<List<BorrowPlace>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<CoverType>> getDatasetCoverType(@ApiParam(value = "The id of the cover type. If not entered then all cover types are listed") @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            List<CoverType> coverTypes = new ArrayList();
            if(id == null){
                coverTypes = bookService.getAllCoverTypes();
                return ResponseEntity.ok(coverTypes);
            }
        }

        return new ResponseEntity<List<CoverType>>(HttpStatus.BAD_REQUEST);
    }

}
