package com.news_articles.resource.article;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ArticleDto.ArticleDtoBuilder.class)
public class ArticleDto {

    private final String title;
    private final String category;
    private final boolean like;

    public ArticleDto(ArticleDtoBuilder articleDtoBuilder) {
        this.title = articleDtoBuilder.title;
        this.category = articleDtoBuilder.category;
        this.like = articleDtoBuilder.like;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public boolean isLike() {
        return this.like;
    }

    public final static class ArticleDtoBuilder {

        private String title;
        private String category;
        private boolean like;

        private ArticleDtoBuilder() {}

        public static ArticleDtoBuilder newArticleDtoBuilder() {
            return new ArticleDtoBuilder();
        }

        public ArticleDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleDtoBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public ArticleDtoBuilder withLike(boolean like) {
            this.like = like;
            return this;
        }

        public ArticleDto build() {
            return new ArticleDto(this);
        }
    }
}
