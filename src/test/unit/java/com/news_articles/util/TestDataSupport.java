package com.news_articles.util;

import com.news_articles.resource.article.ArticleDto;
import com.news_articles.resource.article.ArticlesDto;

import java.util.ArrayList;
import java.util.List;

import static com.news_articles.resource.article.ArticleDto.ArticleDtoBuilder.*;
import static com.news_articles.util.TestSupportRandom.randomString;

public class TestDataSupport {

    public static ArticlesDto createRequestData() {
        var userID = randomString();

        List<ArticleDto> sport = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory("sport")
                .withLike(true)
                .build());
        }

        List<ArticleDto> business = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory("business")
                .withLike(true)
                .build());
        }

        List<ArticleDto> art = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory("art")
                .withLike(true)
                .build());
        }

        List<ArticleDto> entertainment = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory("entertainment")
                .withLike(true)
                .build());
        }

        List<ArticleDto> categories = new ArrayList<>();
        categories.addAll(sport);
        categories.addAll(business);
        categories.addAll(art);
        categories.addAll(entertainment);

        return ArticlesDto.ArticlesDtoBuilder.newArticlesDtoBuilder()
                .withUserID(userID)
                .withArticleDtos(categories)
                .build();
    }

}
