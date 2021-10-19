package com.news_articles.data.persistence;

public class NoRowException extends RuntimeException {
    public NoRowException(String message) {
        super(message);
    }
}
