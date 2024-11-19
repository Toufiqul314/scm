package com.scm.repsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.User;
import java.util.List;
import java.util.Optional;


public interface  UserRepo extends JpaRepository<User, String>{

    //extra methods db reatedoperations
    // custom query methods
    // custom finder methods

    Optional<User> findByEmail(String email);
    
    Optional<User>findByEmailAndPassword(String email, String password);
}
