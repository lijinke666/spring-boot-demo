package com.example.demo.modules;

import lombok.AllArgsConstructor;
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
@Builder(toBuilder = true)// 可以链式的构造
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")      // 标识表名叫什么
public class User {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 自增长
    @Column(name = "id")
    private int id;

    @Column(name = "username", nullable = false)
    @Length(min = 2, max = 10, message = "用户名需要2-10个字符")
    private String username;

    @Column(name = "password", nullable = false)
    @Length(min = 6, max = 12, message = "密码需要6-12个字符")
    private String password;

    @Column(name = "phone", nullable = false, length = 11)
    @Length(min = 11, max = 11, message = "请输入正确的手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private final Role role = Role.USER;
}
