package com.news_articles.data.repository;

public class NoRowException extends RuntimeException {

    public NoRowException(String message) {
        super(message);
    }
}
