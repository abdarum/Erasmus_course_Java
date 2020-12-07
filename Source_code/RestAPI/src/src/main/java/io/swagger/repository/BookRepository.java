package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT d FROM Book d WHERE d.id = ?1")
    Optional<Book> getBookById(Long id);
    
    @Modifying
    @Query("delete from Book d where d.id=?1")
    void deleteBookById(Long id);

    @Query("SELECT d FROM Book d WHERE d.name like %?1%")
    Optional<List<Book>> findByNameLike(String title);

    
}