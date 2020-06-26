package com.example.demo.modules;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data // 添加 getter setter toString hashCode 等方法
@Entity // 数据库实体
@Builder // 可以链式的构造
@Table(name = "user")      // 标识表名叫什么
public class User {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 自增长
    @Column(name = "id")
    private long id;

    @Column(name = "username", nullable = false)
    @Size(min = 2, max = 10)
    @NotBlank
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 12)
    @NotBlank
    private String password;

    @Column(name = "phone", nullable = false, length = 11)
    @Length(min = 11, max = 11)
    @NotBlank
    private String phone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private final Role role = Role.USER;
}
