package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.UserType;

public interface BorrowPlaceRepository extends JpaRepository<UserType,Long> {


}