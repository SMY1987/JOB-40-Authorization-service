package com.netology.job40.auth.repository;

import com.netology.job40.auth.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "admin123".equals(password)) {
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        }
        if ("user".equals(user) && "user123".equals(password)) {
            return List.of(Authorities.READ);
        }

        return List.of();
    }
}