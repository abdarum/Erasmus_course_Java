package io.swagger.service;

import java.util.List;

import io.swagger.model.User;
import io.swagger.model.UserType;


public interface UserService {
    public User createUser(User User);
    public List<User> getAllUsers();
    public User deleteUserByName(String email);
    public User getUserByName(String email);
    public User updateUser(String email, User body);
    public User deleteUserById(Long id);
    public User getUserById(Long id);
    public User updateUserById(Long id, User body);
    public User loginUser(String email, String password);
    public Void logoutUser();

    public UserType getUserTypeById(Long id);
    public Void initUserTypeValues();
    public List<UserType> getAllUserTypes();
    public int countUserTypes();

}