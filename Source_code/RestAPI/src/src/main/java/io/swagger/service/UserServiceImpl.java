package io.swagger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.model.User;
import io.swagger.model.UserToken;
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
    private UserTokenService userTokenService;
    
    
    @Autowired
    private UserTypeService userTypeService;

	@Override
    public Void initUserValues(){
        OffsetDateTime birthdate;
        User admin = new User();
        admin.setUserTypeId(userTypeService.getUserTypeIdByName("Administrator"));
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@lib.com");
        admin.setPassword("admin");
        admin.setPhone("888444666");
        birthdate = OffsetDateTime.of(1990, 12, 6, 12, 25, 0, 0, ZoneOffset.ofHours(0));
        admin.setBirthdate(birthdate);
        admin.setGender("male");
        admin.setAdress("Studentska 1");
        admin.setCity("Varna");
        admin.setStatus(StatusEnum.ACTIVE);
        createUser(admin);
        User librarian = new User();
        librarian.setUserTypeId(userTypeService.getUserTypeIdByName("Librarian"));
        librarian.setFirstName("Librarian");
        librarian.setLastName("Librarian");
        librarian.setEmail("librarian@lib.com");
        librarian.setPassword("librarian");
        librarian.setPhone("111222333");
        birthdate = OffsetDateTime.of(1985, 1, 10, 0, 10, 0, 0, ZoneOffset.ofHours(0));
        librarian.setBirthdate(birthdate);
        librarian.setGender("female");
        librarian.setAdress("Studentska 1");
        librarian.setCity("Varna");
        librarian.setStatus(StatusEnum.ACTIVE);
        createUser(librarian);
        User reader = new User();
        reader.setUserTypeId(userTypeService.getUserTypeIdByName("Reader"));
        reader.setFirstName("User");
        reader.setLastName("User");
        reader.setEmail("reader@lib.com");
        reader.setPassword("reader");
        reader.setPhone("333222555");
        birthdate = OffsetDateTime.of(2000, 3, 15, 15, 30, 0, 0, ZoneOffset.ofHours(0));
        reader.setBirthdate(birthdate);
        reader.setGender("male");
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
    public List<User> getAllNotVeryfiedUsers(){
        List<User> users = new ArrayList<User>();
        User userSearch = new User();
        userSearch.setStatus(StatusEnum.TO_VERYFICATION);
        users = userRepository.findAll(Example.of(userSearch));
        return users;
    }

	@Override
    public List<User> findUsersByStatus(String firstName, String lastName, StatusEnum status, Long userTypeId, String email){
        List<User> users = new ArrayList<>();
        User exampleUser = new User();
        exampleUser.firstName(firstName).lastName(lastName).status(status).userTypeId(userTypeId).email(email);
        users = bookRepository.findAll(Example.of(exampleUser));
        return books;
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
                userTokenService.createToken(tmpUser.getId());
                return tmpUser;
            }
        }
        return null;
    }

	@Override
    public Void logoutUser(Long id){
        userTokenService.deleteUserTokenByUserId(id);
        return null;
    }

	@Override
    public User updateUser(String email, User body){
        Optional<User> od = userRepository.getUserByEmail(email);
		if(od.isPresent()) return userRepository.save(body);
        return null;
    }
    
    @Override
    public Long getUserIdFormToken(String tokenName){
        return userTokenService.getUserIdFormToken(tokenName);
    }

    @Override
    public String getTokenNameFormUser(User user){
        return userTokenService.getTokenNameFormUserId(user.getId());
    }

    @Override
    public User initNewUserAccordingToPermissions(User user, String token){
        Long requestUserId = getUserIdFormToken(token);
        Long requestUserTypeId = getUserTypeIdByUserId(requestUserId);
        if(user.getUserTypeId() == null){
            user.setUserTypeId(userTypeService.getUserTypeIdByName("Reader"));
        }
        if((user.getUserTypeId() == null || user.getUserTypeId() == userTypeService.getUserTypeIdByName("Reader")) &&
            (token == null || !userTypeService.isModifyReaderPermited(requestUserTypeId))
        ){
            user.setStatus(StatusEnum.TO_VERYFICATION);
        }
        return user;
    }



	@Override
    public Boolean isModifyPermittedForToken(User user, String token){
        Long requestUserId = getUserIdFormToken(token);
        Long requestUserTypeId = getUserTypeIdByUserId(requestUserId);

        if(user.getId() == requestUserId){
            return true;
        }
        
        if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Reader")){
            if(token != null){
                return userTypeService.isModifyReaderPermited(requestUserTypeId);
            } else {
                return true;
            }
        }
        if(token != null){
            if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Administrator")){
                return userTypeService.isModifyAdminPermited(requestUserTypeId);
            }
    
            if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Librarian")){
                return userTypeService.isModifyLibrarianPermited(requestUserTypeId);
            }
        }

        return false;
    }


	@Override
    public Boolean isModifyPermittedForToken(Long id, String token){
        try{
            User user  = getUserById(id);
            return isModifyPermittedForToken(user,token);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long getUserTypeIdByUserId(Long id){
        User user = getUserById(id);
        if(user != null){
            return user.getUserTypeId();
        }
        else return null;
    }


	@Override
    public Boolean isViewPermittedForToken(User user, String token){
        Long requestUserId = getUserIdFormToken(token);
        Long requestUserTypeId = getUserTypeIdByUserId(requestUserId);

        if(user.getId() == requestUserId){
            return true;
        }

        if(token != null){
            if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Reader")){
                return userTypeService.isViewReaderPermited(requestUserTypeId);
            }
            
            if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Administrator")){
                return userTypeService.isViewAdminPermited(requestUserTypeId);
            }
    
            if(user.getUserTypeId() == userTypeService.getUserTypeIdByName("Librarian")){
                return userTypeService.isViewLibrarianPermited(requestUserTypeId);
            }
        }

        return false;
    }


	@Override
    public Boolean isViewPermittedForToken(Long id, String token){
        try{
            User user  = getUserById(id);
            return isViewPermittedForToken(user,token);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}