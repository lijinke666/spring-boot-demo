package com.example.demo.repository;

import com.example.demo.modules.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// 继承 JpaRepository 得到常用的 CRUD 方法
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
