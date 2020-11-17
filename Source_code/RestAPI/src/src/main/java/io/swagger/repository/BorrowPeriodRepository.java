package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.UserType;

public interface BorrowPeriodRepository extends JpaRepository<UserType,Long> {


}