package io.swagger.service;
import java.util.List;

import io.swagger.model.UserType;

public interface UserTypeService {
    public UserType getUserTypeById(Long id);
    public Void initUserTypeValues();
    public List<UserType> getAllUserTypes();
    public int countUserTypes();
    public Long getUserTypeIdByName(String name);
    public String getUserTypeNameById(Long id);
    
    public Boolean isModifyAdminPermited(Long typeId);
    public Boolean isModifyLibrarianPermited(Long typeId);
    public Boolean isModifyReaderPermited(Long typeId);
    public Boolean isViewAdminPermited(Long typeId);
    public Boolean isViewLibrarianPermited(Long typeId);
    public Boolean isViewReaderPermited(Long typeId);
    public Boolean isModifyBookPermited(Long typeId);
    public Boolean isNewBorrowPermited(Long typeId);
    public Boolean isModifyBorrowPermited(Long typeId);

    public Boolean isViewLibraryReportPermited(Long typeId);

}
