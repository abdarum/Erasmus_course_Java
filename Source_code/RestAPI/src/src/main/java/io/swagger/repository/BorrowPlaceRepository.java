package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BorrowPlace;

public interface BorrowPlaceRepository extends JpaRepository<BorrowPlace,Long> {


}