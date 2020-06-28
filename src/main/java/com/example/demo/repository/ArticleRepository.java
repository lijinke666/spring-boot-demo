package com.example.demo.repository;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.modules.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(
            value = "select new com.example.demo.dto.ArticleDTO(a.id, a.title, a.content, u.username, u.phone, u.role) from Article a left join User u on a.userId = u.id",
            countQuery = "select count(a.id) from Article a left join User u on a.userId = u.id"
    )
    Page<ArticleDTO> getAllWithUser(Pageable pageable);
}
