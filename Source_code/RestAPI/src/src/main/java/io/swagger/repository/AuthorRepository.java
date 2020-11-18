package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}