package com.example.AuthenticationService.TokenDAO;

import com.example.AuthenticationService.Models.Token;
import com.example.AuthenticationService.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TokenDAO extends ITokenDAO {
    @Autowired
    private TokenRepository tokenRepository;
    /**
     *to get token list which have valid token
     * @param id token's primary key
     * */
   public List<Token> findAllValidTokenByUser(Integer id){
        return  tokenRepository.findAllValidTokenByUser(id);
    }
    /**
     * to make changes for token
     * @param token which token we want to make it changed
     * */
    public void save(Token token){
       tokenRepository.save(token);
    }
    /**
     *to make changes token list
     * @param tokens we want to make changes
     * */
    public void saveAll(List<Token> tokens){
       tokenRepository.saveAll(tokens);
    }
    /**
     *to delete token by id
     * @param id which token we want to delete
     * */
    public void deleteById(Integer id){
       tokenRepository.deleteById(id);
    }
}
