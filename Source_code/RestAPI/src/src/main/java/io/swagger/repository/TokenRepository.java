package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Token;

public interface TokenRepository extends JpaRepository<Token,Long> {


}