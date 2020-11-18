package io.swagger.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.model.Author;
import io.swagger.model.Book;
import io.swagger.model.BookGenre;
import io.swagger.model.BorrowPeriod;
import io.swagger.model.BorrowPlace;
import io.swagger.model.CoverType;
import io.swagger.repository.AuthorRepository;
import io.swagger.repository.BookGenreRepository;
import io.swagger.repository.BookRepository;
import io.swagger.repository.CoverTypeRepository;

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
    public Void initBorrowPeriodValues() {
        borrowPeriodRepository.save(new BorrowPeriod("1 week", 7));
        borrowPeriodRepository.save(new BorrowPeriod("2 weeks", 14));
        borrowPeriodRepository.save(new BorrowPeriod("1 month", 30));
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
    public List<BorrowPeriod> getAllBorrowPeriods() {
		return borrowPeriodRepository.findAll();
    }
}
