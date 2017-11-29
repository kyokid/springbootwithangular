package com.example.demo.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByUsernameAndPassword(String userName, String password);
}
