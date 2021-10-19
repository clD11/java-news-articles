package com.news_articles.service.article;

import com.news_articles.data.model.Article;
import com.news_articles.data.persistence.InsertRowException;
import com.news_articles.data.persistence.SimpleDatabase;
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

    public void save(String userID, List<Article> articles) {
        try {
            simpleDatabase.save(userID, articles);
        } catch (Exception e) {
            throw new ArticleServiceException("Could not create articles", e);
        }
    }
}
