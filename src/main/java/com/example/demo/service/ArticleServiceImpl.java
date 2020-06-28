package com.example.demo.service;

import com.example.demo.modules.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id"));
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article getOne(int articleId) {
        return articleRepository.getOne(articleId);
    }

    @Override
    public void deleteOne(int articleId) {
        articleRepository.deleteById(articleId);
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    @Query(
            value = "select a.title, a.content, u.username, u.phone from Article a left join User u on a.userId = u.id",
            countQuery = "select count(a.id) from Article a left join User u on a.userId = u.id"
    )
    public Page<Article> getAllWithUser(int page, int size) {
        return null;
    }
}
