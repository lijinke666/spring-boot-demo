package com.example.demo.modules;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@Table(name = "article")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    @Size(max = 20)
    @NotBlank
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    @NotBlank
    private String content;

    @Column(name = "userId", nullable = false)
    @NotBlank
    private long userId;
}
