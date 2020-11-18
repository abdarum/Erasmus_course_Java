package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BorrowPeriod;

public interface BorrowPeriodRepository extends JpaRepository<BorrowPeriod,Long> {


}