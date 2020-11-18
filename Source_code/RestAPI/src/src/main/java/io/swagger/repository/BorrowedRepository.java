package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import io.swagger.model.Borrowed;

public interface BorrowedRepository extends JpaRepository<Borrowed,Long> {
    @Query("SELECT d FROM Borrowed d WHERE d.id=?1")
    Optional<Borrowed> getOrderById(Long id);
    
    @Modifying
    @Query("delete from Borrowed d where d.id=?1")
    void deleteOrderById(Long id);


}