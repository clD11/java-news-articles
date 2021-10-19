package com.news_articles.service.article;

import com.news_articles.data.model.Article;
import com.news_articles.data.persistence.InsertRowException;
import com.news_articles.data.persistence.SimpleDatabase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static util.TestSupportRandom.randomString;

class ArticleServiceTest {

    private final SimpleDatabase simpleDatabase = mock(SimpleDatabase.class);

    @Test
    void shouldSaveArticles() {
        String userID = randomString();
        List<Article> articles = List.of();

        ArticleService articleService = new ArticleService(simpleDatabase);

        assertDoesNotThrow(() -> articleService.save(userID, articles));
        verify(simpleDatabase).save(userID, articles);
    }

    @Test
    void shouldThrowArticleServiceException() {
        String userID = randomString();
        List<Article> articles = List.of();
        doThrow(InsertRowException.class).when(simpleDatabase).save(userID, articles);

        ArticleService articleService = new ArticleService(simpleDatabase);
        ArticleServiceException actual = assertThrows(ArticleServiceException.class,
                () -> articleService.save(userID, articles));
        assertThat(actual.getMessage(), is("Could not create articles"));
    }

}