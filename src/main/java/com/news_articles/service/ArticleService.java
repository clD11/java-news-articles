package com.news_articles.service;

import com.news_articles.data.model.Article;
import com.news_articles.data.repository.InsertRowException;
import com.news_articles.data.repository.SimpleDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final SimpleDatabase simpleDatabase;

    @Autowired
    public ArticleService(SimpleDatabase simpleDatabase) {
        this.simpleDatabase = simpleDatabase;
    }

    public void create(String userID, List<Article> articles) {
        try {
            simpleDatabase.insert(userID, articles);
        } catch (InsertRowException ire) {
            throw new RuntimeException("article service: could not create articles", ire);
        }
    }
}
