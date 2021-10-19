package com.news_articles.resource.article;

import com.news_articles.data.model.Article;
import com.news_articles.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleResource {

    private final ArticleMapper articleMapper;
    private final ArticleService articleService;

    @Autowired
    ArticleResource(ArticleMapper articleMapper, ArticleService articleService) {
        this.articleMapper = articleMapper;
        this.articleService = articleService;
    }

    @PostMapping
    ResponseEntity<String> postArticles(@RequestBody ArticlesDto articlesDto) {
        List<Article> articles = articleMapper.map(articlesDto);
        articleService.save(articlesDto.getUserID(), articles);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
