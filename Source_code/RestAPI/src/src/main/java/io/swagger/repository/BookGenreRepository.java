package io.swagger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre,Long> {
    @Query("SELECT d FROM BookGenre d WHERE d.id = ?1")
    Optional<BookGenre> getBookGenreById(Long id);

	@Query("SELECT d.id FROM BookGenre d WHERE d.name=?1")
    Optional<Long> getBookGenreIdByName(String name);
}