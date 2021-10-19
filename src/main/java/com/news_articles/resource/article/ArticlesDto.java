package com.news_articles.resource.article;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(builder = ArticlesDto.ArticlesDtoBuilder.class)
public class ArticlesDto {

    private final String userID;
    private final List<ArticleDto> articleDtos;

    public ArticlesDto(ArticlesDtoBuilder builder) {
        this.userID = builder.userID;
        this.articleDtos = builder.articleDtos;
    }

    public String getUserID() {
        return this.userID;
    }

    public List<ArticleDto> getArticleDtos() {
        return this.articleDtos;
    }

    public final static class ArticlesDtoBuilder {

        private String userID;
        private List<ArticleDto> articleDtos;

        private ArticlesDtoBuilder() {}

        public static ArticlesDtoBuilder newArticlesDtoBuilder() {
            return new ArticlesDtoBuilder();
        }

        public ArticlesDtoBuilder withUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public ArticlesDtoBuilder withArticleDtos(List<ArticleDto> articleDtos) {
            this.articleDtos = articleDtos;
            return this;
        }

        public ArticlesDto build() {
            return new ArticlesDto(this);
        }
    }
}
