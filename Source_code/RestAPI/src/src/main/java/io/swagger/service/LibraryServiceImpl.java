package io.swagger.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Author;
import io.swagger.model.Book;
import io.swagger.model.BookGenre;
import io.swagger.model.BookReport;
import io.swagger.model.BorrowPeriod;
import io.swagger.model.BorrowPlace;
import io.swagger.model.Borrowed;
import io.swagger.model.CoverType;
import io.swagger.model.LibraryBooksReport;
import io.swagger.model.Book.StatusEnum;
import io.swagger.repository.AuthorRepository;
import io.swagger.repository.BookGenreRepository;
import io.swagger.repository.BookRepository;
import io.swagger.repository.CoverTypeRepository;
import io.swagger.repository.UserTypeRepository;
import io.swagger.repository.BorrowPeriodRepository;
import io.swagger.repository.BorrowPlaceRepository;
import io.swagger.repository.BorrowedRepository;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BorrowedRepository borrowedRepository;
    
    @Autowired
    private BorrowPeriodRepository borrowPeriodRepository;

    @Autowired
    private BorrowPlaceRepository borrowPlaceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserTypeService userTypeService; 
    
    @Override
    public Void initBorrowPlaceValues() {
        borrowPlaceRepository.save(new BorrowPlace("Archive"));
        borrowPlaceRepository.save(new BorrowPlace("Reading room"));
        borrowPlaceRepository.save(new BorrowPlace("Home loan"));
        return null;

    }

    @Override
    public int countBorrowPlaces() {
        List<BorrowPlace> borrowPlaces = getAllBorrowPlaces();
        return borrowPlaces.size();
    }

    @Override
    public List<BorrowPlace> getAllBorrowPlaces() {
		return borrowPlaceRepository.findAll();
    }

    @Override
    public BorrowPlace getBorrowPlaceById(Long id){
        Optional<BorrowPlace> od = borrowPlaceRepository.getBorrowPlaceById(id);
        if(od.isPresent()) return od.get();
        else return null;
    }

    @Override
    public String getBorrowPlaceNameById(Long id){
        Optional<BorrowPlace> od = borrowPlaceRepository.getBorrowPlaceById(id);
        String returnString = null;
        if(od.isPresent()){
            returnString = od.get().getName();
        }
        if(returnString != null) return returnString;
        else return null;
    }

    @Override
    public Void initBorrowPeriodValues() {
        borrowPeriodRepository.save(new BorrowPeriod("1 week", 7));
        borrowPeriodRepository.save(new BorrowPeriod("2 weeks", 14));
        borrowPeriodRepository.save(new BorrowPeriod("1 month", 31));
        borrowPeriodRepository.save(new BorrowPeriod("3 months", 92));
        borrowPeriodRepository.save(new BorrowPeriod("6 months", 183));
        return null;
    }

    @Override
    public int countBorrowPeriods() {
        List<BorrowPeriod> borrowPeriods = getAllBorrowPeriods();
        return borrowPeriods.size();
    }

    @Override
    public Integer getValueBorrowPeriodsById(Long id) {
        Optional<Integer> od = borrowPeriodRepository.getBorrowPeriodValueById(id);
		if(od.isPresent()){
            return od.get();
        } 
        return null;
    }

    @Override
    public List<BorrowPeriod> getAllBorrowPeriods() {
		return borrowPeriodRepository.findAll();
    }

    @Override
    public BorrowPeriod getBorrowPeriodById(Long id){
        Optional<BorrowPeriod> od = borrowPeriodRepository.getBorrowPeriodById(id);
        if(od.isPresent()) return od.get();
        else return null;
    }

    @Override
    public String getBorrowPeriodNameById(Long id){
        Optional<BorrowPeriod> od = borrowPeriodRepository.getBorrowPeriodById(id);
        String returnString = null;
        if(od.isPresent()){
            returnString = od.get().getName();
        }
        if(returnString != null) return returnString;
        else return null;
    }

    @Override
    public Void initBorrowedValues() {
        Borrowed borrowed;
        // **************************
        //  ID 51
        borrowed = new Borrowed();
        borrowed.setUserId(Long.valueOf(6));
        borrowed.setBookId(Long.valueOf(34));
        borrowed.setBorrowedDate(OffsetDateTime.now());
        borrowed.setPlaceId(Long.valueOf(45));
        borrowed.setPeriodId(Long.valueOf(47));
        borrowed.setDamageNotes("");
        createOrder(borrowed);
        // **************************
        //  ID 52
        borrowed = new Borrowed();
        borrowed.setUserId(Long.valueOf(6));
        borrowed.setBookId(Long.valueOf(36));
        borrowed.setBorrowedDate(OffsetDateTime.now().minusDays(25));
        borrowed.setReturnedDate(OffsetDateTime.now());
        borrowed.setPlaceId(Long.valueOf(45));
        borrowed.setPeriodId(Long.valueOf(47));
        borrowed.setDamageNotes("Book was burned");
        createOrder(borrowed);
        // **************************
        //  ID 53
        borrowed = new Borrowed();
        borrowed.setUserId(Long.valueOf(6));
        borrowed.setBookId(Long.valueOf(38));
        borrowed.setBorrowedDate(OffsetDateTime.now().minusDays(45));
        borrowed.setPlaceId(Long.valueOf(45));
        borrowed.setPeriodId(Long.valueOf(47));
        createOrder(borrowed);
        // **************************
        //  ID 54
        borrowed = new Borrowed();
        borrowed.setUserId(Long.valueOf(6));
        borrowed.setBookId(Long.valueOf(40));
        borrowed.setBorrowedDate(OffsetDateTime.now().minusDays(30));
        borrowed.setPlaceId(Long.valueOf(45));
        borrowed.setPeriodId(Long.valueOf(48));
        createOrder(borrowed);
        // **************************
        //  ID 55
        borrowed = new Borrowed();
        borrowed.setUserId(Long.valueOf(5));
        borrowed.setBookId(Long.valueOf(33));
        borrowed.setBorrowedDate(OffsetDateTime.now());
        borrowed.setPlaceId(Long.valueOf(45));
        borrowed.setPeriodId(Long.valueOf(47));
        createOrder(borrowed);
        // **************************
        return null;

    }

    @Override
    public int countBorrowed() {
        List<Borrowed> borrowedList = getAllBorrowed();
        return borrowedList.size();
    }

    @Override
    public List<Borrowed> getAllBorrowed() {
		return borrowedRepository.findAll();
    }

    @Override
    public Borrowed deleteOrderById(Long orderId){
        Optional<Borrowed> od = borrowedRepository.getOrderById(orderId);
		if(od.isPresent()){
            borrowedRepository.deleteOrderById(orderId);
            return od.get();
        } 
        return null;
    }

    @Override
	public Borrowed createOrder(Borrowed borrowed){
        Optional<Borrowed> od = borrowedRepository.getOrderById(borrowed.getId());
        if(!od.isPresent() && validateOrder(borrowed)){
            Borrowed borrowedInRepository = borrowedRepository.save(borrowed);
            if(borrowed.getReturnedDate() == null){
                bookService.updateBookStatus(borrowedInRepository.getBookId(), StatusEnum.IN_USE);
            }
            return borrowedInRepository;
        } 
        return null;
    }

    @Override
    public Boolean validateOrder(Borrowed borrowed){
        Boolean orderValid = true;
        try{
            if(borrowed.getBorrowedDate() != null){
                if(borrowed.getReturnedDate() != null){
                    if (!borrowed.checkReturnedDateValid()){
                        orderValid = false; 
                    }
                }
            } else {
                orderValid = false; 
            }

            if(userService.getUserById(borrowed.getUserId()) == null){
                orderValid = false; 
            }
            if(bookService.getBookById(borrowed.getBookId()) == null){
                orderValid = false; 
            }
            if(getBorrowPlaceById(borrowed.getPlaceId()) == null){
                orderValid = false; 
            }
            if(getBorrowPeriodById(borrowed.getPeriodId()) == null){
                orderValid = false; 
            }

            return orderValid;
        } catch(Exception e) {
            return null;
        }
    }

	@Override
    public Borrowed getOrderById(Long orderId){
        Optional<Borrowed> od = borrowedRepository.getOrderById(orderId);
        if(od.isPresent()) return od.get();
        else return null;
    }

	@Override
    public Borrowed updateOrderById(Long orderId, Borrowed body){
        Optional<Borrowed> od = borrowedRepository.getOrderById(orderId);
        if(od.isPresent() && validateOrder(body)) {
            if(body.getId() == null) 
                body.setId(orderId);
            if(od.get().getReturnedDate() == null && body.getReturnedDate() != null) 
                bookService.updateBookStatus(body.getBookId(), StatusEnum.AVAILABLE);
            return borrowedRepository.save(body);
        } else {
            return null;
        } 
    }
    
	@Override
    public List<Borrowed> getAllBorrowedByUser(Long userId){
        List<Borrowed> borrowedList = new ArrayList<Borrowed>();
        Borrowed borrowedSearch = new Borrowed();
        borrowedSearch.setUserId(userId);
        borrowedList = borrowedRepository.findAll(Example.of(borrowedSearch));
        return borrowedList;
    }

    public List<Borrowed> getAllDamagedBorrowedBooksByList(List<Borrowed> receivedBorrowedList){
        List<Borrowed> borrowedList = new ArrayList<Borrowed>();
        for(Borrowed borrowed : receivedBorrowedList) {
            if(borrowed.getDamageNotes() != null && !borrowed.getDamageNotes().equals("")){
                borrowedList.add(borrowed);
            }
        }
        return borrowedList;
    }

    @Override
    public List<Borrowed> getAllCurrentBorrowedBooksByList(List<Borrowed> receivedBorrowedList){
        List<Borrowed> borrowedList = new ArrayList<Borrowed>();
        for(Borrowed borrowed : receivedBorrowedList) {
            if(borrowed.getReturnedDate() == null){
                borrowedList.add(borrowed);
            }
        }
        return borrowedList;
    }

    @Override
    public List<Borrowed> getAllDelayedBorrowedBooksByList(List<Borrowed> receivedBorrowedList){
        List<Borrowed> borrowedList = new ArrayList<Borrowed>();
        for(Borrowed borrowed : receivedBorrowedList) {
            if(borrowed.checkReturnDelayed(getValueBorrowPeriodsById(borrowed.getPeriodId()))){
                borrowedList.add(borrowed);
            }
        }
        return borrowedList;
    }

    @Override
    public Boolean isModifyBorrowedPermittedForToken(Borrowed borrowed, String token){
        Long requestUserId = userService.getUserIdFormToken(token);
        Long requestUserTypeId = userService.getUserTypeIdByUserId(requestUserId);

        if(token != null && requestUserTypeId != null){
            return userTypeService.isModifyBorrowPermited(requestUserTypeId);
        }

        return false;
    }


	@Override
    public Boolean isModifyBorrowedPermittedForToken(Long id, String token){
        try{
            Borrowed borrowed  = getOrderById(id);
            return isModifyBorrowedPermittedForToken(borrowed,token);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Boolean isViewBorrowedPermittedForToken(Borrowed borrowed, String token){
        Long requestUserId = userService.getUserIdFormToken(token);
        Long requestUserTypeId = userService.getUserTypeIdByUserId(requestUserId);

        // if(token != null && requestUserTypeId != null){
        //     return userTypeService.isModifyBorrowPermited(requestUserTypeId);
        // }
        return true;
    }


	@Override
    public Boolean isViewBorrowedPermittedForToken(Long id, String token){
        try{
            Borrowed borrowed  = getOrderById(id);
            return isViewBorrowedPermittedForToken(borrowed,token);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean isNewBorrowedPermittedForToken(Borrowed borrowed, String token){
        Long requestUserId = userService.getUserIdFormToken(token);
        Long requestUserTypeId = userService.getUserTypeIdByUserId(requestUserId);

        if(token != null && requestUserTypeId != null){
            return userTypeService.isNewBorrowPermited(requestUserTypeId);
        }

        return false;
    }


	@Override
    public Boolean isNewBorrowedPermittedForToken(Long id, String token){
        try{
            Borrowed borrowed  = getOrderById(id);
            return isNewBorrowedPermittedForToken(borrowed,token);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

	@Override
    public Boolean isViewLibraryReportPermittedForToken(String token){
        Long requestUserId = userService.getUserIdFormToken(token);
        Long requestUserTypeId = userService.getUserTypeIdByUserId(requestUserId);

        if(token != null && requestUserTypeId != null){
            return userTypeService.isViewLibraryReportPermited(requestUserTypeId);
        }

        return false;
    }


	@Override
    public LibraryBooksReport getLibraryInventoryBooks(){
        LibraryBooksReport booksReport = new LibraryBooksReport();
        List<Book> availableBooks = bookService.getAllAvailableBooks();
        booksReport.setNumberOfAvailableBooks(availableBooks.size());
        booksReport.setNumberOfBooks(bookService.countBooks());
        for(Book book: availableBooks){
            BookReport bookReport = new BookReport(book);
            System.out.println(book.toString());
            bookReport.setAuthorTypeName(bookService.getAuthorNameById(book.getAuthorId()));
            bookReport.setCoverTypeName(bookService.getCoverTypeNameById(book.getCoverTypeId()));
            bookReport.setGenreName(bookService.getBookGenreNameById(book.getGenreId()));
            bookReport.setSugeredPeriodName(this.getBorrowPeriodNameById(book.getSugeredPeriodId()));
            bookReport.setSugeredPlaceName(this.getBorrowPlaceNameById(book.getSugeredPlaceId()));
            bookReport.setStatusName(book.getStatus().name());
            booksReport.addBooksItem(bookReport);
        }
        return booksReport;       
    }

}
