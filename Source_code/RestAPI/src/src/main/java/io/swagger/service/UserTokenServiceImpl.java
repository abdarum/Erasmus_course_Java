package io.swagger.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.repository.UserTokenRepository;
import io.swagger.model.UserToken;

@Service
@Transactional
public class UserTokenServiceImpl implements UserTokenService {


    @Autowired
    private UserTokenRepository tokenRepository;  

    @Override
    public UserToken createToken(Long userId){
        return createToken(new UserToken(userId));
    }

    @Override
    public UserToken createToken(UserToken token){
        Optional<UserToken> od = tokenRepository.getUserTokenById(token.getUserId());
        if(!od.isPresent()) {
            return tokenRepository.save(token);
        } else {
            token = od.get();
            token.extendExpireDatetime();
            tokenRepository.save(token);
        }
        return null;
    }

    @Override
    public UserToken deleteUserTokenByUserId(Long userId){
        Optional<UserToken> od = tokenRepository.getUserTokenById(userId);
		if(od.isPresent()) tokenRepository.deleteUserTokenById(userId);
		return od.get();
    }

    @Override
    public Long getUserIdFormToken(String tokenName){
        Optional<Long> od = tokenRepository.getUserIdFormToken(tokenName);
        if(od.isPresent()) return od.get();
        else return null;
    }

    @Override
    public String getTokenNameFormUserId(Long userId){
        Optional<UserToken> od = tokenRepository.getUserTokenById(userId);
        if(od.isPresent()) return od.get().getTokenName();
        else return null;
    }

    
}