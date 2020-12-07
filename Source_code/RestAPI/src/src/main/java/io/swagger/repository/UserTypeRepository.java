package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType,Long> {
	@Query("SELECT d.id FROM UserType d WHERE d.name=?1")
    Optional<Long> getUserTypeIdByName(String name);

}