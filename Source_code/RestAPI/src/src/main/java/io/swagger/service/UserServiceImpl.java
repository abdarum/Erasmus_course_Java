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

import io.swagger.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;    
    
	@Override
	public User createUser(User User) {
        System.out.println("createUser in UserServiceImpl");
        System.out.println(User.toString());
        return userRepository.save(User);
    }	

	@Override
    public List<User> getAllUsers(){
		return userRepository.findAll();
    }

	@Override
    public User deleteUser(String email){
        Optional<User> od = userRepository.getUserByEmail(email);
		if(od.isPresent()) userRepository.deleteUserByEmail(email);
		return od.get();
    }


	@Override
    public User getUserByName(String email){
        Optional<User> od = userRepository.getUserByEmail(email);
        if(od.isPresent()) return od.get();
        else return null;
    }

	@Override
    public User loginUser(String email, String password){
        User tmpUser = getUserByName(email);
        if (tmpUser != null){
            if (tmpUser.getPassword().equals(password)) {
                return tmpUser;
            }
        }
        return null;
    }

	@Override
    public Void logoutUser(){
        return null;
    }

	@Override
    public User updateUser(String email, User body){
        Optional<User> od = userRepository.getUserByEmail(email);
		if(od.isPresent()) return userRepository.save(body);
        return null;
    }

}