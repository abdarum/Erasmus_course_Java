package io.swagger.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.model.User;
import io.swagger.model.UserType;
import io.swagger.model.User.StatusEnum;
import io.swagger.repository.UserRepository;
import io.swagger.repository.UserTypeRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;    

    @Autowired
    private UserTypeRepository userTypeRepository;    
    

	@Override
    public Void initUserValues(){
        OffsetDateTime birthdate;
        User admin = new User();
        admin.setUserTypeId(Long.valueOf(1));
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@lib.com");
        admin.setPassword("admin");
        admin.setPhone("888444666");
        birthdate = OffsetDateTime.of(1990, 12, 6, 12, 25, 0, 0, ZoneOffset.ofHours(0));
        admin.setBirthdate(birthdate);
        admin.setGender("man");
        admin.setAdress("Studentska 1");
        admin.setCity("Varna");
        admin.setStatus(StatusEnum.ACTIVE);
        createUser(admin);
        User librarian = new User();
        librarian.setUserTypeId(Long.valueOf(2));
        librarian.setFirstName("Librarian");
        librarian.setLastName("Librarian");
        librarian.setEmail("librarian@lib.com");
        librarian.setPassword("librarian");
        librarian.setPhone("111222333");
        birthdate = OffsetDateTime.of(1985, 1, 10, 0, 10, 0, 0, ZoneOffset.ofHours(0));
        librarian.setBirthdate(birthdate);
        librarian.setGender("woman");
        librarian.setAdress("Studentska 1");
        librarian.setCity("Varna");
        librarian.setStatus(StatusEnum.ACTIVE);
        createUser(librarian);
        User reader = new User();
        reader.setUserTypeId(Long.valueOf(3));
        reader.setFirstName("User");
        reader.setLastName("User");
        reader.setEmail("reader@lib.com");
        reader.setPassword("reader");
        reader.setPhone("333222555");
        birthdate = OffsetDateTime.of(2000, 3, 15, 15, 30, 0, 0, ZoneOffset.ofHours(0));
        reader.setBirthdate(birthdate);
        reader.setGender("man");
        reader.setAdress("Studentska 1");
        reader.setCity("Varna");
        reader.setStatus(StatusEnum.TO_VERYFICATION);
        createUser(reader);
        return null;
    }
    
    @Override
    public int countUsers(){
        List<User> users = getAllUsers();
        return users.size();
    }

	@Override
	public User createUser(User user) {
        OffsetDateTime registrated = OffsetDateTime.now(ZoneId.of("UTC"));
        user.setRegistrated(registrated);
        
        Optional<User> od = userRepository.getUserByEmail(user.getEmail());
        if(!od.isPresent()) return userRepository.save(user);
        return null;
    }	

	@Override
    public List<User> getAllUsers(){
		return userRepository.findAll();
    }

	@Override
    public User deleteUserByName(String email){
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
    public User deleteUserById(Long id){
        Optional<User> od = userRepository.getUserById(id);
		if(od.isPresent()){
            userRepository.deleteUserById(id);
            return od.get();
        } 
        return null;
    }

	@Override
    public User getUserById(Long id){
        Optional<User> od = userRepository.getUserById(id);
        if(od.isPresent()) return od.get();
        else return null;
    }

	@Override
    public User updateUserById(Long id, User body){
        Optional<User> od = userRepository.getUserById(id);
        if(od.isPresent()) {
            if(body.getId() == null) body.setId(id);
            return userRepository.save(body);
        } else {
            return null;
        } 
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

    @Override
    public UserType getUserTypeById(Long id){
        Optional<UserType> od = userTypeRepository.findById(id);
        if(od.isPresent()) return od.get();
        else return null;
    }

    @Override
    public List<UserType> getAllUserTypes(){
		return userTypeRepository.findAll();
    }

    @Override
    public Void initUserTypeValues(){
        userTypeRepository.save(new UserType("Administrator"));
        userTypeRepository.save(new UserType("Librarian"));
        userTypeRepository.save(new UserType("Reader"));
        return null;
    }

    @Override
    public int countUserTypes(){
        List<UserType> userTypes = getAllUserTypes();
        return userTypes.size();
    }
}