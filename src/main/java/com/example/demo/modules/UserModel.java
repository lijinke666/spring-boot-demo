package com.example.demo.modules;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data // 添加 getter setter toString hashCode 等方法
@Entity // 数据库实体
@Table(name = "user")      // 标识表名叫什么
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
