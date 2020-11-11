package io.swagger.service;

import java.util.List;

import io.swagger.model.User;


public interface UserService {
    public User createUser(User User);
    public List<User> getAllUsers();
    public User deleteUser(String email);
    public User getUserByName(String email);
    public User loginUser(String email, String password);
    public Void logoutUser();
    public User updateUser(String email, User body);

}