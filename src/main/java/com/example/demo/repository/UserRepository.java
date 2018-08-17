package com.example.demo.repository;

import com.example.demo.modules.UserModel;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserModel, String> {

    List<UserModel> findAll();

    UserModel findById(String id);
}
