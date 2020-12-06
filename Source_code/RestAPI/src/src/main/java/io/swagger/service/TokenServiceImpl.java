package io.swagger.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.repository.TokenRepository;
import io.swagger.model.Token;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {


    @Autowired
    private TokenRepository tokenRepository;  

    public void createToken(Token token){
        tokenRepository.save(token);
    }

    
}