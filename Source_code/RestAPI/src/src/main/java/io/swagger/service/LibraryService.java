package io.swagger.service;

import java.util.List;

import io.swagger.model.BorrowPlace;
import io.swagger.model.Borrowed;
import io.swagger.model.BorrowPeriod;


public interface LibraryService {
    public Void initBorrowPlaceValues();
    public int countBorrowPlaces();
    public List<BorrowPlace> getAllBorrowPlaces();
    public BorrowPlace getBorrowPlaceById(Long id);
    public Void initBorrowPeriodValues();
    public int countBorrowPeriods();
    public List<BorrowPeriod> getAllBorrowPeriods();
    public Integer getValueBorrowPeriodsById(Long id);
    public BorrowPeriod getBorrowPeriodById(Long id);

    public Void initBorrowedValues();
    public int countBorrowed();
    public List<Borrowed> getAllBorrowed();

	public Borrowed createOrder(Borrowed borrowed);
    public Boolean validateOrder(Borrowed borrowed);
    public Borrowed deleteOrderById(Long orderId);
    public Borrowed getOrderById(Long orderId);
    public Borrowed updateOrderById(Long orderId, Borrowed body);

    public List<Borrowed> getAllBorrowedByUser(Long userId);
    public List<Borrowed> getAllDamagedBorrowedBooksByList(List<Borrowed> receivedBorrowedList);
    public List<Borrowed> getAllCurrentBorrowedBooksByList(List<Borrowed> receivedBorrowedList);
    public List<Borrowed> getAllDelayedBorrowedBooksByList(List<Borrowed> receivedBorrowedList);

}
