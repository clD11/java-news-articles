package com.news_articles.service.article;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.TestSupportRandom.randomString;

class ArticleServiceExceptionTest {

    @Test
    void shouldCreateArticleServiceException() {
        String message = randomString();
        Exception exception = new Exception();
        ArticleServiceException articleServiceException = new ArticleServiceException(message, exception);
        assertThat(articleServiceException.getMessage(), is(message));
        assertThat(articleServiceException.getCause(), is(exception));
    }

}