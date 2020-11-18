package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Borrowed;

public interface BorrowedRepository extends JpaRepository<Borrowed,Long> {


}