package com.example.demo.modules;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data                      //lombok 提供的 getter setter 方法n  也就是下面 所有 set get 方法
//@NoArgsConstructor         //lombok 提供的 无参构造 表示 生成一个 空对象
@Entity
@Table(name = "user")      //jpa 提供的注解 标识表名叫什么
public class UserModel {
    @Id                     //@id 为必须
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age ;

    @Column(name = "sex")
    private int sex;

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
