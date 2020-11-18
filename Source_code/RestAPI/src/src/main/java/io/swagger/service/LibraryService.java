package io.swagger.service;

import java.util.List;

import io.swagger.model.BorrowPlace;
import io.swagger.model.Borrowed;
import io.swagger.model.BorrowPeriod;


public interface LibraryService {
    public Void initBorrowPlaceValues();
    public int countBorrowPlaces();
    public List<BorrowPlace> getAllBorrowPlaces();
    public Void initBorrowPeriodValues();
    public int countBorrowPeriods();
    public List<BorrowPeriod> getAllBorrowPeriods();

	public Borrowed createOrder(Borrowed borrowed);
    public Borrowed deleteOrderById(Long orderId);
    public Borrowed getOrderById(Long orderId);
    public Borrowed updateUserById(Long orderId, Borrowed body);
    }
