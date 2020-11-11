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

import io.swagger.model.Library;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository LibraryRepository;    
    
	@Override
	public Library createLibrary(Library Library) {
        System.out.println("createLibrary in LibraryServiceImpl");
        System.out.println(Library.toString());
        return LibraryRepository.save(Library);
    }	

	@Override
    public List<Library> getAllLibrarys(){
		return LibraryRepository.findAll();
    }

	@Override
    public Library deleteLibrary(String email){
        Optional<Library> od = LibraryRepository.getLibraryByEmail(email);
		if(od.isPresent()) LibraryRepository.deleteLibraryByEmail(email);
		return od.get();
    }


	@Override
    public Library getLibraryByName(String email){
        Optional<Library> od = LibraryRepository.getLibraryByEmail(email);
        if(od.isPresent()) return od.get();
        else return null;
    }

	@Override
    public Library loginLibrary(String email, String password){
        Library tmpLibrary = getLibraryByName(email);
        if (tmpLibrary != null){
            if (tmpLibrary.getPassword().equals(password)) {
                return tmpLibrary;
            }
        }
        return null;
    }

	@Override
    public Void logoutLibrary(){
        return null;
    }

	@Override
    public Library updateLibrary(String email, Library body){
        Optional<Library> od = LibraryRepository.getLibraryByEmail(email);
		if(od.isPresent()) return LibraryRepository.save(body);
        return null;
    }

}