package io.swagger.service;

import java.util.List;

import io.swagger.model.User;
import io.swagger.model.UserType;


public interface UserService {
    public Void initUserValues();
    public int countUsers();
    public User createUser(User User);
    public List<User> getAllUsers();
    public List<User> getAllNotVeryfiedUsers();
    public List<User> findUsersByStatus(String firstName, String lastName, String status, Long userTypeId, String email );
    
    public User deleteUserByName(String email);
    public User getUserByName(String email);
    public User updateUser(String email, User body);
    public User deleteUserById(Long id);
    public User getUserById(Long id);
    public User updateUserById(Long id, User body);
    public User loginUser(String email, String password);
    public Void logoutUser(Long id);

    public Long getUserIdFormToken(String tokenName);
    public String getTokenNameFormUser(User user);
    
    public User initNewUserAccordingToPermissions(User user, String token);
    public Long getUserTypeIdByUserId(Long id);
    public Boolean isModifyPermittedForToken(User user, String token);
    public Boolean isModifyPermittedForToken(Long id, String token);
    public Boolean isViewPermittedForToken(User user, String token);
    public Boolean isViewPermittedForToken(Long id, String token);

}