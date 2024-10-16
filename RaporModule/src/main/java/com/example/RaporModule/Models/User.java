package com.example.RaporModule.Models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.List;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer  id;
    String firstname;
    String lastname;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @Column(nullable = true)
    private boolean isDeleted=false;
/**
 * to get role owner's authority
 * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
        /**
         * to return user's username
         * */
    @Override
    public String getUsername() {
        return email;
    }
    /**
     * to notify token does not time out
     * */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * to notify token is valid
     * */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * to notify credential time is valid
     * */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * to notify token is enables
     * */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
