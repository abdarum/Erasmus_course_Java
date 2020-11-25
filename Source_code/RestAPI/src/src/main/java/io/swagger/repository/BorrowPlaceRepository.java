package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import io.swagger.model.BorrowPlace;

public interface BorrowPlaceRepository extends JpaRepository<BorrowPlace,Long> {
    @Query("SELECT d FROM BorrowPlace d WHERE d.id = ?1")
    Optional<BorrowPlace> getBorrowPlaceById(Long id);
}