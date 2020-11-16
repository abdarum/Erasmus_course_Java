package io.swagger.service;

import java.util.List;

import io.swagger.model.Book;


public interface BookService {
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book deleteBookById(Long id);
    public Book getBookById(Long id);
    public Book loginBook(String email, String password);
    public Void logoutBook();
    public Book updateBookById(Long id, Book body);

}