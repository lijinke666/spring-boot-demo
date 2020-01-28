package com.example.demo.modules;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user")      //jpa 提供的注解 标识表名叫什么
public class UserModel {
    @Id                     //@id 为必须 主键
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password ;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private Role role;
}
