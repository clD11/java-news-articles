package com.news_articles.resource.article;

import com.news_articles.data.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public List<Article> map(ArticlesDto articlesDto) {
        return articlesDto.getArticleDtos().stream().map(this::map)
                .collect(Collectors.toList());
    }

    public Article map(ArticleDto articleDto) {
        return Article.ArticleBuilder
                .newArticleBuilder()
                .withTitle(articleDto.getTitle())
                .withCategory(articleDto.getCategory())
                .withLike(articleDto.isLike())
                .build();
    }

}
