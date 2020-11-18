package io.swagger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
	@Query("SELECT d.id FROM Author d WHERE d.firstName=?1 AND d.lastName=?2")
    Optional<Long> getAuthorIdByName(String firstName, String lastName);

}