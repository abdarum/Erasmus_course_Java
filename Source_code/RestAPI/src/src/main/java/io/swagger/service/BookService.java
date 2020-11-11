package io.swagger.service;

import java.util.List;

import io.swagger.model.Book;


public interface BookService {
    public Book createBook(Book Book);
    public List<Book> getAllBooks();
    public Book deleteBook(String email);
    public Book getBookByName(String email);
    public Book loginBook(String email, String password);
    public Void logoutBook();
    public Book updateBook(String email, Book body);

}