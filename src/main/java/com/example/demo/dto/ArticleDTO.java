package com.example.demo.dto;

import com.example.demo.modules.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String title;
    private String content;
    private String username;
    private String phone;
    private Role role;
}
