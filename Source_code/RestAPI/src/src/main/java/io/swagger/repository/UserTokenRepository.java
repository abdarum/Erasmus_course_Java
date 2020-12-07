package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import io.swagger.model.UserToken;

public interface UserTokenRepository extends JpaRepository<UserToken,Long> {
    @Query("SELECT d FROM UserToken d WHERE d.userId=?1")
    Optional<UserToken> getUserTokenById(Long userId);

    @Query("SELECT d.userId FROM UserToken d WHERE d.tokenName=?1")
    Optional<Long> getUserIdFormToken(String tokenName);

    @Modifying
    @Query("delete from UserToken d where d.userId=?1")
    void deleteUserTokenById(Long userId);

}