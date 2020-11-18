package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.CoverType;

public interface CoverTypeRepository extends JpaRepository<CoverType,Long> {


}