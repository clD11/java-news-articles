package com.news_articles.service.article;

public class ArticleServiceException extends RuntimeException {
    public ArticleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
