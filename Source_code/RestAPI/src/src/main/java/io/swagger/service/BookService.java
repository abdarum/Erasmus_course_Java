package io.swagger.service;

import java.util.List;

import io.swagger.model.Book;


public interface BookService {
    public Book createBook(Book Book);
    public List<Book> getAllBooks();
    public Book deleteBookById(Integer id);
    public Book getBookById(Integer id);
    public Book loginBook(String email, String password);
    public Void logoutBook();
    public Book updateBookByI(Integer id, Book body);

}