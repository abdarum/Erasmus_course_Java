package io.swagger.service;

import java.util.List;

import io.swagger.model.Book;


public interface BookService {
    public Void initBookValues();
    public int countBooks();
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book deleteBookById(Long id);
    public Book getBookById(Long id);
    public Book loginBook(String email, String password);
    public Void logoutBook();
    public Book updateBookById(Long id, Book body);

    public Void initAuthorValues();
    public int countAuthors();
    public Void initBookGenreValues();
    public int countBookGenres();
    public Void initCoverTypeValues();
    public int countCoverTypes();

}