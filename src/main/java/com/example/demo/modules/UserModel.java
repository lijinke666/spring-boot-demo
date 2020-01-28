package com.example.demo.modules;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")      //jpa 提供的注解 标识表名叫什么
public class UserModel {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 自增长
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private Role role;
}
