package com.example.demo.controller;

import com.example.demo.modules.Article;
import com.example.demo.modules.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ArticleServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.xml.ws.http.HTTPException;
import java.util.Optional;

// Controller => Service (implement interface) => Repository

@RestController
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/articles")
    public Page<Article> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "5") int size
            ) {

        return articleService.getAll(page, size);
    }

    @GetMapping("/articles/{id}")
    public Article getUserById(@PathVariable int id) {
        return articleService.getOne(id);
    }

    @PostMapping("/articles")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Article createUser(@Valid @RequestBody Article article) {
        return articleService.create(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteUser(@PathVariable int id) {
        articleService.deleteOne(id);
    }

}
