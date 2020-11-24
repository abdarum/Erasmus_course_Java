package io.swagger.api;

import io.swagger.model.Borrowed;
import io.swagger.model.LibraryStats;
import io.swagger.model.NotificationForm;
import io.swagger.service.LibraryService;

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
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")

@Controller
public class LibraryApiController implements LibraryApi {

    private static final Logger log = LoggerFactory.getLogger(LibraryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private LibraryService libraryService;

    @org.springframework.beans.factory.annotation.Autowired
    public LibraryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteOrder(@Min(1L)@ApiParam(value = "ID of the order that needs to be deleted",required=true) @PathVariable("orderId") Long orderId) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        // String accept = request.getHeader("Accept");
        // if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
        //     Borrowed borrowed = libraryService.deleteOrderById(orderId);
        //     if (borrowed != null) {
        //         return new ResponseEntity<Void>(HttpStatus.OK);
        //     } else { 
        //         return ResponseEntity.notFound().build();
        //     }
        // } 
        // else 
        // {
        //     return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        // }
    }

    public ResponseEntity<LibraryStats> getLibraryInventory() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LibraryStats>(objectMapper.readValue("{  \"numberOfAvailableBooks\" : 6,  \"numberOfBooks\" : 0}", LibraryStats.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LibraryStats>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LibraryStats>(HttpStatus.NOT_IMPLEMENTED);
    }

    public SseEmitter notifyBook()
    {
        SseEmitter emitter = new SseEmitter();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        cachedThreadPool.execute(() -> {
           try {
               for (int i = 0; i < 10; i++) {
                   emitter.send(Integer.toString(i));
                   TimeUnit.SECONDS.sleep(1);
               }

               emitter.complete();
           } catch (Exception e) {
               emitter.completeWithError(e);
           }
       });

       return emitter;
    }

    public ResponseEntity<List<NotificationForm>> getLibraryNotyfications() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<NotificationForm>>(objectMapper.readValue("[ {  \"data\" : \"{}\",  \"id\" : 0,  \"event\" : \"event\"}, {  \"data\" : \"{}\",  \"id\" : 0,  \"event\" : \"event\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<NotificationForm>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<NotificationForm>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Borrowed> getOrderById(@Min(1L) @Max(10L) @ApiParam(value = "ID of borrow form that needs to be fetched",required=true) @PathVariable("orderId") Long orderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            Borrowed borrowed = libraryService.getOrderById(orderId);
            if (borrowed != null) {
                return ResponseEntity.ok(borrowed);
            } else { 
                return ResponseEntity.notFound().build();
            }
        }
        return new ResponseEntity<Borrowed>(HttpStatus.BAD_REQUEST);
    
    }

    public ResponseEntity<Borrowed> placeOrder(@ApiParam(value = "order placed for borrow the book" ,required=true )  @Valid @RequestBody Borrowed body) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(libraryService.validateOrder(body)){
                Borrowed borrowed = libraryService.createOrder(body);
                if(borrowed != null){
                    return ResponseEntity.ok(borrowed);
                } else {
                    return new ResponseEntity<Borrowed>(HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<Borrowed>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<Borrowed>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Borrowed> putOrderById(@Min(1L) @Max(10L) @ApiParam(value = "ID of pet that needs to be fetched",required=true) @PathVariable("orderId") Long orderId,@ApiParam(value = "form ot the borrowed book that needs to update" ,required=true )  @Valid @RequestBody Borrowed body) {
        String accept = request.getHeader("Accept");
        if (accept != null && (accept.contains("application/json") || accept.contains("*/*")) ){
            if(libraryService.validateOrder(body)){
                Borrowed borrowed = libraryService.updateOrderById(orderId, body);
                if (borrowed != null) {
                    return new ResponseEntity<Borrowed>(HttpStatus.OK);
                } else { 
                    return ResponseEntity.notFound().build();
                }
            } else {
                return new ResponseEntity<Borrowed>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Borrowed>(HttpStatus.BAD_REQUEST);
    }

}
