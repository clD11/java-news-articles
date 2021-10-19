package com.news_articles.data.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Article.ArticleBuilder.class)
public class Article {

    private final String title;
    private final String category;
    private final boolean like;

    public Article(ArticleBuilder articleBuilder) {
        this.title = articleBuilder.title;
        this.category = articleBuilder.category;
        this.like = articleBuilder.like;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isLike() {
        return like;
    }

    public static final class ArticleBuilder {

        private String title;
        private String category;
        private boolean like;

        private ArticleBuilder() {}

        public static ArticleBuilder newArticleBuilder() {
            return new ArticleBuilder();
        }

        public ArticleBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public ArticleBuilder withLike(boolean like) {
            this.like = like;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }

}
