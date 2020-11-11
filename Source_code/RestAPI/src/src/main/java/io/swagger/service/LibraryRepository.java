package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.Library;

public interface LibraryRepository extends JpaRepository<Library,Long> {
	@Query("SELECT d FROM Library d WHERE d.email = ?1")
    Optional<Library> getLibraryByEmail(String email);
    
    @Modifying
    @Query("delete from Library d where d.email=?1")
    void deleteLibraryByEmail(String email);

    // // TO DO !!!
    // // sorted by( current date - appointment date)
    // // where email == doc email
    // // @Query("SELECT a FROM Library a WHERE a.email = ?1")
    // //SELECT a FROM Appointment as a WHERE (SELECT email FROM a.Librarys where a.Librarys == ?1)AND (CURRENT_TIMESTAMP - a.start_appointment > 0) ORDER BY a.start_appointment DESC LIMIT ?2"; 
    // //                                                                              < 0                               ASC
    // Optional<List<Appointment>> getLibraryAppointmentsByNumberOfLastByNumberAndSort(String email, Integer number, Integer sort);
    
    // // TO DO !!!
    // // @Query("delete from Library d where d.email=?1")
    // Optional<List<Conversation>> getLibraryConversationByNumberOfLast(String email, Integer number);

    // // TO DO !!!
    // // @Query("delete from Library d where d.email=?1")
    // Optional<List<Message>> getLibraryMessagesFromConversationByNumberOfLast(String email, Long id, Integer number);

    // @Query("SELECT d FROM Library d WHERE d.email = ?1 and d.password = ?2")
    // Optional<Library> loginLibrary(String email, String password);

}