package io.swagger.service;

import java.util.List;

import io.swagger.model.Author;
import io.swagger.model.Book;
import io.swagger.model.BookGenre;
import io.swagger.model.CoverType;


public interface BookService {
    public Void initBookValues();
    public int countBooks();
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book deleteBookById(Long id);
    public Book getBookById(Long id);
    public Book updateBookById(Long id, Book body);

    public Void initAuthorValues();
    public int countAuthors();
    public List<Author> getAllAuthors();
    public Void initBookGenreValues();
    public int countBookGenres();
    public List<BookGenre> getAllBookGenres();
    public Void initCoverTypeValues();
    public int countCoverTypes();
    public List<CoverType> getAllCoverTypes();

    public List<Book> findBookByStatus(String status, String author, String title, String genere);
    public Boolean isModifyBookPermittedForToken(Book book, String token);
    public Boolean isModifyBookPermittedForToken(Long i, String token);


}