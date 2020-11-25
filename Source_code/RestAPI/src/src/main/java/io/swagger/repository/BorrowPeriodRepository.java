package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BorrowPeriod;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface BorrowPeriodRepository extends JpaRepository<BorrowPeriod,Long> {
    @Query("SELECT d FROM BorrowPeriod d WHERE d.id = ?1")
    Optional<BorrowPeriod> getBorrowPeriodById(Long id);

    @Query("SELECT d.period FROM BorrowPeriod d WHERE d.id=?1")
    Optional<Integer> getBorrowPeriodValueById(Long id);

}