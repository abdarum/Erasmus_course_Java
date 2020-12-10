package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import io.swagger.model.CoverType;

public interface CoverTypeRepository extends JpaRepository<CoverType,Long> {
    @Query("SELECT d FROM CoverType d WHERE d.id = ?1")
    Optional<CoverType> getCoverTypeById(Long id);


	@Query("SELECT d.id FROM CoverType d WHERE d.name=?1")
    Optional<Long> getCoverTypeIdByName(String name);

}