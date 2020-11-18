package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre,Long> {


}