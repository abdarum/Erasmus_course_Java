package io.swagger.service;
import io.swagger.model.UserToken;



public interface UserTokenService {
    public UserToken createToken(UserToken token);
    public UserToken createToken(Long userId);
    public UserToken deleteUserTokenByUserId(Long userId);

    public Long getUserIdFormToken(String tokenName);
    public String getTokenNameFormUserId(Long userId);

}