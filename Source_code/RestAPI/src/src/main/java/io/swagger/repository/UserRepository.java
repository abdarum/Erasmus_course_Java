package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	@Query("SELECT d FROM User d WHERE d.email=?1")
    Optional<User> getUserByEmail(String email);
    
    @Modifying
    @Query("delete from User d where d.email=?1")
    void deleteUserByEmail(String email);

    @Query("SELECT d FROM User d WHERE d.id=?1")
    Optional<User> getUserById(Long id);
    
    @Modifying
    @Query("delete from User d where d.id=?1")
    void deleteUserById(Long id);

}