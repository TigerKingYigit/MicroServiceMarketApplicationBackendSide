package com.example.SaleModule.Repository;


import com.example.SaleModule.Models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    /**
     * to get token informations by making inner join user and token
     * @param id Entity's primary key
     * */
    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Integer id);
    /**
     * to get token by
     * @param token a hashed data address of token class
     * */

    Optional<Token> findByToken(String token);
}