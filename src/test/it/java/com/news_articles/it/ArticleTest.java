package com.news_articles.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.news_articles.resource.article.ArticleDto.ArticleDtoBuilder.newArticleDtoBuilder;
import static com.news_articles.resource.article.ArticlesDto.ArticlesDtoBuilder.newArticlesDtoBuilder;
import static com.news_articles.util.TestSupportRandom.randomBoolean;
import static com.news_articles.util.TestSupportRandom.randomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldPostArticles() {
        var articleDto = newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory(randomString())
                .withLike(randomBoolean())
                .build();

        var articlesDto = newArticlesDtoBuilder()
                .withUserID(randomString())
                .withArticleDtos(List.of(articleDto))
                .build();

        String url = String.format("http://localhost:%d/api/v1/articles", port);

        var actual = testRestTemplate.postForEntity(url, articlesDto, String.class);
        assertThat(actual.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    void shouldReturnBadRequestWhenArticlesAlreadyStoredAgainstUserID() {
        var articleDto = newArticleDtoBuilder()
                .withTitle(randomString())
                .withCategory(randomString())
                .withLike(randomBoolean())
                .build();

        var articlesDto = newArticlesDtoBuilder()
                .withUserID(randomString())
                .withArticleDtos(List.of(articleDto))
                .build();

        String url = String.format("http://localhost:%d/api/v1/articles", port);

        var response = testRestTemplate.postForEntity(url, articlesDto, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

        var actual = testRestTemplate.postForEntity(url, articlesDto, String.class);
        assertThat(actual.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }
}