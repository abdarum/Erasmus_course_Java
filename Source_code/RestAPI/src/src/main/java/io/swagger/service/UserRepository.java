package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	@Query("SELECT d FROM User d WHERE d.email = ?1")
    Optional<User> getUserByEmail(String email);
    
    @Modifying
    @Query("delete from User d where d.email=?1")
    void deleteUserByEmail(String email);

    // // TO DO !!!
    // // sorted by( current date - appointment date)
    // // where email == doc email
    // // @Query("SELECT a FROM User a WHERE a.email = ?1")
    // //SELECT a FROM Appointment as a WHERE (SELECT email FROM a.users where a.users == ?1)AND (CURRENT_TIMESTAMP - a.start_appointment > 0) ORDER BY a.start_appointment DESC LIMIT ?2"; 
    // //                                                                              < 0                               ASC
    // Optional<List<Appointment>> getUserAppointmentsByNumberOfLastByNumberAndSort(String email, Integer number, Integer sort);
    
    // // TO DO !!!
    // // @Query("delete from User d where d.email=?1")
    // Optional<List<Conversation>> getUserConversationByNumberOfLast(String email, Integer number);

    // // TO DO !!!
    // // @Query("delete from User d where d.email=?1")
    // Optional<List<Message>> getUserMessagesFromConversationByNumberOfLast(String email, Long id, Integer number);

    // @Query("SELECT d FROM User d WHERE d.email = ?1 and d.password = ?2")
    // Optional<User> loginUser(String email, String password);

}