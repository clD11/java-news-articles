package util;

import com.news_articles.data.model.Article;
import com.news_articles.resource.article.ArticleDto;
import com.news_articles.resource.article.ArticlesDto;

import java.util.ArrayList;
import java.util.List;

import static com.news_articles.resource.article.ArticleDto.ArticleDtoBuilder.*;

public class TestDataSupport {

    /**
     * This test support class creates dummy test data for the final task.
     *
     * Each of the Articles has a title, category and like
     *
     * If a user likes a category the like field is set to true
     *
     * A category with the most likes would be the users favourite
     *
     */

    public static ArticlesDto createRequestData() {
        var userID = TestSupportRandom.randomString();

        List<ArticleDto> sport = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(TestSupportRandom.randomString())
                .withCategory("sport")
                .withLike(true)
                .build());
        }

        List<ArticleDto> business = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(TestSupportRandom.randomString())
                .withCategory("business")
                .withLike(true)
                .build());
        }

        List<ArticleDto> art = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(TestSupportRandom.randomString())
                .withCategory("art")
                .withLike(true)
                .build());
        }

        List<ArticleDto> entertainment = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            sport.add(newArticleDtoBuilder()
                .withTitle(TestSupportRandom.randomString())
                .withCategory("entertainment")
                .withLike(true)
                .build());
        }

        List<ArticleDto> categories = new ArrayList<>();
        categories.addAll(sport);
        categories.addAll(business);
        categories.addAll(art);
        categories.addAll(entertainment);

        return ArticlesDto.ArticlesDtoBuilder.newArticlesDtoBuilder()
                .withUserID(userID)
                .withArticleDtos(categories)
                .build();
    }

    public static List<Article> createArticles() {
        List<Article> sport = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sport.add(Article.ArticleBuilder.newArticleBuilder()
                    .withTitle(TestSupportRandom.randomString())
                    .withCategory("sport")
                    .withLike(true)
                    .build());
        }

        List<Article> business = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sport.add(Article.ArticleBuilder.newArticleBuilder()
                    .withTitle(TestSupportRandom.randomString())
                    .withCategory("business")
                    .withLike(true)
                    .build());
        }

        List<Article> art = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sport.add(Article.ArticleBuilder.newArticleBuilder()
                    .withTitle(TestSupportRandom.randomString())
                    .withCategory("art")
                    .withLike(true)
                    .build());
        }

        List<Article> entertainment = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            sport.add(Article.ArticleBuilder.newArticleBuilder()
                    .withTitle(TestSupportRandom.randomString())
                    .withCategory("entertainment")
                    .withLike(true)
                    .build());
        }

        List<Article> categories = new ArrayList<>();
        categories.addAll(sport);
        categories.addAll(business);
        categories.addAll(art);
        categories.addAll(entertainment);

        return categories;
    }

}
