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

import io.swagger.model.Author;
import io.swagger.model.Book;
import io.swagger.model.BookGenre;
import io.swagger.model.CoverType;
import io.swagger.repository.AuthorRepository;
import io.swagger.repository.BookGenreRepository;
import io.swagger.repository.BookRepository;
import io.swagger.repository.CoverTypeRepository;

// import io.swagger.repository.BorrowPeriodRepository;
// import io.swagger.repository.BorrowPlaceRepository;
// import io.swagger.repository.BorrowedRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookGenreRepository bookGenreRepository;
    
    @Autowired
    private BookRepository bookRepository;    

    // @Autowired
    // private BorrowedRepository borrowedRepository;
    
    // @Autowired
    // private BorrowPeriodRepository borrowPeriodRepository;

    // @Autowired
    // private BorrowPlaceRepository borrowPlaceRepository;
    
    @Autowired
    private CoverTypeRepository coverTypeRepository;
    
    @Override
    public Void initBookValues() {
        return null;
    }

    @Override
    public int countBooks(){
        List<Book> books = getAllBooks();
        return books.size();
    }

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

    @Override
    public Void initAuthorValues() {
        return null;
    }

    @Override
    public int countAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors.size();
    }

    @Override
    public Void initBookGenreValues() {
        return null;
    }

    @Override
    public int countBookGenres(){
        List<BookGenre> bookGenres = bookGenreRepository.findAll();
        return bookGenres.size();
    }

    @Override
    public Void initCoverTypeValues() {
        return null;
    }

    @Override
    public int countCoverTypes(){
        List<CoverType> coverTypes = coverTypeRepository.findAll();
        return coverTypes.size();
    }
}