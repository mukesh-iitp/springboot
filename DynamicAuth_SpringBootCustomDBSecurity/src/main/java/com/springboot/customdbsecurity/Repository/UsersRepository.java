package com.springboot.customdbsecurity.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.customdbsecurity.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
    //It is called by the developer wherever we are writing the code that method will be called by the framework.
    //findByName => select * from users where name=username.
    //Optional => May have the data or not have the data. 

}

