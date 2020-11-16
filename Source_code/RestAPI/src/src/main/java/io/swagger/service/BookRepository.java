package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT d FROM Book d WHERE d.id = ?1")
    Optional<Book> getBookById(Long id);
    
    @Modifying
    @Query("delete from Book d where d.id=?1")
    void deleteBookById(Long id);

    // // TO DO !!!
    // // sorted by( current date - appointment date)
    // // where email == doc email
    // // @Query("SELECT a FROM Book a WHERE a.email = ?1")
    // //SELECT a FROM Appointment as a WHERE (SELECT email FROM a.Books where a.Books == ?1)AND (CURRENT_TIMESTAMP - a.start_appointment > 0) ORDER BY a.start_appointment DESC LIMIT ?2"; 
    // //                                                                              < 0                               ASC
    // Optional<List<Appointment>> getBookAppointmentsByNumberOfLastByNumberAndSort(String email, Integer number, Integer sort);
    
    // // TO DO !!!
    // // @Query("delete from Book d where d.email=?1")
    // Optional<List<Conversation>> getBookConversationByNumberOfLast(String email, Integer number);

    // // TO DO !!!
    // // @Query("delete from Book d where d.email=?1")
    // Optional<List<Message>> getBookMessagesFromConversationByNumberOfLast(String email, Long id, Integer number);

    // @Query("SELECT d FROM Book d WHERE d.email = ?1 and d.password = ?2")
    // Optional<Book> loginBook(String email, String password);

}