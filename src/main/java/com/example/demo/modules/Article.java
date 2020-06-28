package com.example.demo.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "article")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    @Size(max = 20)
    @NotBlank
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    @NotBlank
    private String content;

    @Column(name = "user_id", nullable = false)
    @NotBlank
    private int userId;
}
