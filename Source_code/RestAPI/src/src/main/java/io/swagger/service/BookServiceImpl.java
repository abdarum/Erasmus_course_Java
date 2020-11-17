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
import io.swagger.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;    
    
	@Override
	public Book createBook(Book book) {
        return bookRepository.save(book);
    }	

	@Override
    public List<Book> getAllBooks(){
		return bookRepository.findAll();
    }

	@Override
    public Book deleteBookById(Long id){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) bookRepository.deleteBookById(id);
        return od.get();
    }


	@Override
    public Book getBookById(Long id){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) return od.get();
        else return null;
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
    public Book updateBookById(Long id, Book body){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) return bookRepository.save(body);
        return null;
    }

}