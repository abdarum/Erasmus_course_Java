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
        return bookRepository.save(Book);
    }	

	@Override
    public List<Book> getAllBooks(){
		return bookRepository.findAll();
    }

	@Override
    public Book deleteBookById(Integer id){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) bookRepository.deleteBookById(id);
        return od.get();
    }


	@Override
    public Book getBookById(Integer id){
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
    public Book updateBookByI(Integer id, Book body){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) return bookRepository.save(body);
        return null;
    }

}