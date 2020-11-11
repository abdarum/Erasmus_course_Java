package io.swagger.service;

import java.util.List;

import io.swagger.model.Library;


public interface LibraryService {
    public Library createLibrary(Library Library);
    public List<Library> getAllLibrarys();
    public Library deleteLibrary(String email);
    public Library getLibraryByName(String email);
    public Library loginLibrary(String email, String password);
    public Void logoutLibrary();
    public Library updateLibrary(String email, Library body);

}