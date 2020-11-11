package io.swagger.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;    
    
	@Override
	public Book createBook(Book Book) {
        System.out.println("createBook in BookServiceImpl");
        System.out.println(Book.toString());
        return bookRepository.save(Book);
    }	

	@Override
    public List<Book> getAllBooks(){
		return bookRepository.findAll();
    }

	@Override
    public Book deleteBook(String email){
        // Optional<Book> od = bookRepository.getBookByEmail(email);
		// if(od.isPresent()) bookRepository.deleteBookByEmail(email);
		// return od.get();
		return null;
    }


	@Override
    public Book getBookByName(String email){
        // Optional<Book> od = bookRepository.getBookByEmail(email);
        // if(od.isPresent()) return od.get();
        // else return null;
		return null;
    }

	@Override
    public Book loginBook(String email, String password){
        // Book tmpBook = getBookByName(email);
        // if (tmpBook != null){
        //     if (tmpBook.getPassword().equals(password)) {
        //         return tmpBook;
        //     }
        // }
        return null;
    }

	@Override
    public Void logoutBook(){
        return null;
    }

	@Override
    public Book updateBook(String email, Book body){
        // Optional<Book> od = bookRepository.getBookByEmail(email);
		// if(od.isPresent()) return bookRepository.save(body);
        return null;
    }

}