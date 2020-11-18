package io.swagger.service;

import java.util.List;

import io.swagger.model.BorrowPlace;
import io.swagger.model.BorrowPeriod;


public interface LibraryService {
    public Void initBorrowPlaceValues();
    public int countBorrowPlaces();
    public List<BorrowPlace> getAllBorrowPlaces();
    public Void initBorrowPeriodValues();
    public int countBorrowPeriods();
    public List<BorrowPeriod> getAllBorrowPeriods();
}
