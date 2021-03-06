package com.example.demo.service;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.modules.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {
   Page<Article> getAll(int page, int size);

   Page<ArticleDTO> getAllWithUser(int page, int size);

   Article getOne(int articleId);

   void deleteOne(int articleId);

   Article create(Article article);
}
