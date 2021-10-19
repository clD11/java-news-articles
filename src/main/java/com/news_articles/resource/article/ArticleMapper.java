package com.news_articles.resource.article;

import com.news_articles.data.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public ArticlesDto map(String userID, List<Article> articles) {
        List<ArticleDto> articleDtos = articles.stream().map(this::map)
                .collect(Collectors.toList());
        return ArticlesDto.ArticlesDtoBuilder.newArticlesDtoBuilder()
                .withUserID(userID)
                .withArticleDtos(articleDtos)
                .build();
    }

    public ArticleDto map(Article article) {
        return ArticleDto.ArticleDtoBuilder.newArticleDtoBuilder()
                .withTitle(article.getTitle())
                .withCategory(article.getCategory())
                .withLike(article.isLike())
                .build();
    }

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
