package io.swagger.service;

import java.util.List;

import io.swagger.model.Author;
import io.swagger.model.Book;
import io.swagger.model.BookGenre;
import io.swagger.model.CoverType;
import io.swagger.model.Book.StatusEnum;


public interface BookService {
    public Void initBookValues();
    public int countBooks();
    public int countAvailableBooks();
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book deleteBookById(Long id);
    public Book getBookById(Long id);
    public String getBookNameById(Long id);
    public Book updateBookById(Long id, Book body);
    public Boolean updateBookStatus(Long id, StatusEnum status);
    public List<Book> getAllAvailableBooks();

    public Void initAuthorValues();
    public int countAuthors();
    public List<Author> getAllAuthors();
    public String getAuthorNameById(Long id);
    public Void initBookGenreValues();
    public int countBookGenres();
    public List<BookGenre> getAllBookGenres();
    public String getBookGenreNameById(Long id);
    public Void initCoverTypeValues();
    public int countCoverTypes();
    public List<CoverType> getAllCoverTypes();
    public String getCoverTypeNameById(Long id);

    public List<Book> findBookByStatus(String status, String author, String title, String genere);
    public Boolean isModifyBookPermittedForToken(String token);
    public Boolean isModifyBookPermittedForToken(Book book, String token);
    public Boolean isModifyBookPermittedForToken(Long i, String token);
    public Boolean isViewBookPermittedForToken(Book book, String token);
    public Boolean isViewBookPermittedForToken(Long i, String token);


}