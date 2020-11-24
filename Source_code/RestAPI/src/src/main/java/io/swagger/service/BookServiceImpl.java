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

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookGenreRepository bookGenreRepository;
    
    @Autowired
    private BookRepository bookRepository;    
    
    @Autowired
    private CoverTypeRepository coverTypeRepository;
    
    @Override
    public Void initBookValues() {
        Optional<Long> authorId;
        Optional<Long> bookGenreId;
        Optional<Long> coverTypeId;
        Book book;
        // **************************
        book = new Book();
        authorId = authorRepository.getAuthorIdByName("Victoria", "Thompson");
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Mystery");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Paperback");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Murder on St. Mark's Place");
        book.setPageCount(277);
        createBook(book);
        // **************************
        book = new Book();
        authorId = authorRepository.getAuthorIdByName("Stieg", "Larsson");
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Fiction");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Paperback");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("The Girl with the Dragon Tattoo");
        book.setPageCount(465);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Romance");
        authorId = authorRepository.getAuthorIdByName("Mimi", "Jean Pamfiloff");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Dust Jacket");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Tailored for Trouble");
        book.setPageCount(354);
        createBook(book);
        // **************************
        book = new Book();
        authorId = authorRepository.getAuthorIdByName("José", "Donoso");
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Fiction");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Case Wrap");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("The Obscene Bird of Night");
        book.setPageCount(438);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Fantasy");
        authorId = authorRepository.getAuthorIdByName("Patricia", "C. Wrede");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Paperback");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Sorcery & Cecelia: or The Enchanted Chocolate Pot");
        book.setPageCount(326);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Sequential Art");
        authorId = authorRepository.getAuthorIdByName("Steve", "Niles");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Dust Jacket");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("30 Days of Night, Vol. 1");
        book.setPageCount(104);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Young Adult");
        authorId = authorRepository.getAuthorIdByName("Jillian", "Dodd");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Case Wrap");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Stalk Me");
        book.setPageCount(327);
        createBook(book);
        // **************************
        book = new Book();
        authorId = authorRepository.getAuthorIdByName("Mary", "Roach");
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Nonfiction");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Dust Jacket");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Bonk: The Curious Coupling of Science and Sex");
        book.setPageCount(319);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Paranormal");
        authorId = authorRepository.getAuthorIdByName("Nancy", "Baker");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Case Wrap");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Kiss of the Vampire");
        book.setPageCount(278);
        createBook(book);
        // **************************
        book = new Book();
        bookGenreId = bookGenreRepository.getBookGenreIdByName("Young Adult");
        authorId = authorRepository.getAuthorIdByName("Simone", "Elkeles");
        coverTypeId = coverTypeRepository.getCoverTypeIdByName("Paperback");
        if(authorId.isPresent()) book.setAuthorId(authorId.get());
        if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        book.setName("Leaving Paradise");
        book.setPageCount(303);
        createBook(book);
        // **************************
        // book = new Book();
        // if(authorId.isPresent()) book.setAuthorId(authorId.get());
        // if(bookGenreId.isPresent()) book.setGenreId(bookGenreId.get());
        // if(coverTypeId.isPresent()) book.setCoverTypeId(coverTypeId.get());
        // book.setName("name");
        // book.setPageCount(100);
        // createBook(book);
        // // **************************
        
        // authorId = authorRepository.getAuthorIdByName("Victoria", "Thompson");
        // authorId = authorRepository.getAuthorIdByName("Stieg", "Larsson");
        // authorId = authorRepository.getAuthorIdByName("Mimi", "Jean Pamfiloff");
        // authorId = authorRepository.getAuthorIdByName("José", "Donoso");
        // authorId = authorRepository.getAuthorIdByName("Patricia", "C. Wrede");
        // authorId = authorRepository.getAuthorIdByName("Steve", "Niles");
        // authorId = authorRepository.getAuthorIdByName("Jillian", "Dodd");
        // authorId = authorRepository.getAuthorIdByName("Mary", "Roach");
        // authorId = authorRepository.getAuthorIdByName("Nancy", "Baker");
        // authorId = authorRepository.getAuthorIdByName("Simone", "Elkeles");

        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Fantasy");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Young Adult");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Fiction");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Sci-Fi");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Mystery");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Thriller");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Romance");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Westerns");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Dystopian");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Contemporary");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Nonfiction");
        // bookGenreId = bookGenreRepository.getBookGenreIdByName("Paranormal");

        // coverTypeId = coverTypeRepository.getCoverTypeIdByName("Paperback");
        // coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Case Wrap");
        // coverTypeId = coverTypeRepository.getCoverTypeIdByName("Hardcover Dust Jacket");
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
    public Book updateBookById(Long id, Book body){
        Optional<Book> od = bookRepository.getBookById(id);
        if(od.isPresent()) {
            if(body.getId() == null) body.setId(id);
            return bookRepository.save(body);
        }
        return null;
    }

    @Override
    public Void initAuthorValues() {
        authorRepository.save(new Author("Victoria", "Thompson"));
        authorRepository.save(new Author("Stieg", "Larsson"));
        authorRepository.save(new Author("Mimi", "Jean Pamfiloff"));
        authorRepository.save(new Author("José", "Donoso"));
        authorRepository.save(new Author("Patricia", "C. Wrede"));
        authorRepository.save(new Author("Steve", "Niles"));
        authorRepository.save(new Author("Jillian", "Dodd"));
        authorRepository.save(new Author("Mary", "Roach"));
        authorRepository.save(new Author("Nancy", "Baker"));
        authorRepository.save(new Author("Simone", "Elkeles"));

        return null;
    }

    @Override
    public int countAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors.size();
    }

    @Override
    public List<Author> getAllAuthors(){
		return authorRepository.findAll();
    }

    @Override
    public Void initBookGenreValues() {
        bookGenreRepository.save(new BookGenre("Fantasy"));
        bookGenreRepository.save(new BookGenre("Fiction"));
        bookGenreRepository.save(new BookGenre("Sci-Fi"));
        bookGenreRepository.save(new BookGenre("Mystery"));
        bookGenreRepository.save(new BookGenre("Thriller"));
        bookGenreRepository.save(new BookGenre("Romance"));
        bookGenreRepository.save(new BookGenre("Westerns"));
        bookGenreRepository.save(new BookGenre("Dystopian"));
        bookGenreRepository.save(new BookGenre("Contemporary"));
        bookGenreRepository.save(new BookGenre("Sequential Art"));
        bookGenreRepository.save(new BookGenre("Young Adult"));
        bookGenreRepository.save(new BookGenre("Nonfiction"));
        bookGenreRepository.save(new BookGenre("Paranormal"));
        return null;
    }

    @Override
    public int countBookGenres(){
        List<BookGenre> bookGenres = bookGenreRepository.findAll();
        return bookGenres.size();
    }

    @Override
    public List<BookGenre> getAllBookGenres(){
		return bookGenreRepository.findAll();
    }

    
    @Override
    public Void initCoverTypeValues() {
        coverTypeRepository.save(new CoverType("Paperback"));
        coverTypeRepository.save(new CoverType("Hardcover Case Wrap"));
        coverTypeRepository.save(new CoverType("Hardcover Dust Jacket"));
        return null;
    }

    @Override
    public int countCoverTypes(){
        List<CoverType> coverTypes = coverTypeRepository.findAll();
        return coverTypes.size();
    }
    @Override
    public List<CoverType> getAllCoverTypes(){
		return coverTypeRepository.findAll();
    }
}