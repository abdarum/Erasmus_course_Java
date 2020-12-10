package io.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.model.UserType;
import io.swagger.repository.UserTypeRepository;

@Service
@Transactional
public class UserTypeServiceImpl implements UserTypeService {
    
    @Autowired
    private UserTypeRepository userTypeRepository;  
    
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
        userTypeRepository.save(new UserType("Administrator", "modify_librarian;modify_admin;modify_reader;view_admins;view_librarians;view_readers;modify_book;new_borrow;modify_borrow;view_library_report;"));
        userTypeRepository.save(new UserType("Librarian", "modify_reader;view_readers;modify_book;new_borrow;modify_borrow;view_library_report;"));
        userTypeRepository.save(new UserType("Reader", "new_borrow;"));
        return null;
    }

    @Override
    public int countUserTypes(){
        List<UserType> userTypes = getAllUserTypes();
        return userTypes.size();
    }

    @Override
    public Long getUserTypeIdByName(String name){
        Optional<Long> od = userTypeRepository.getUserTypeIdByName(name);
        if(od.isPresent()) return od.get();
        else return null;
    }

    @Override
    public String getUserTypeNameById(Long id){
        UserType userType = getUserTypeById(id);
        String returnString = null;
        if(userType != null){
            returnString = userType.getName();
        }
        if(returnString != null) return returnString;
        else return null;
    }

    @Override
    public Boolean isModifyAdminPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("modify_admin;");
        }
        return false;
    }

    @Override
    public Boolean isModifyLibrarianPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("modify_librarian;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isModifyReaderPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("modify_reader;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isViewAdminPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("view_admins;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isViewLibrarianPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("view_librarians;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isViewReaderPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("view_readers;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isModifyBookPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("modify_book;");
        }
        return false;
    }
    
    
    @Override
    public Boolean isNewBorrowPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("new_borrow;");
        }
        return false;
    }
 
    @Override
    public Boolean isModifyBorrowPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("modify_borrow;");
        }
        return false;
    }

    public Boolean isViewLibraryReportPermited(Long typeId){
        UserType userType = getUserTypeById(typeId);
        if(userType != null){
            return userType.getPermissions().contains("view_library_report;");
        }
        return false;
    }

    
}
