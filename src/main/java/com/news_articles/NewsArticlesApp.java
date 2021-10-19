package com.news_articles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.news_articles")
public class NewsArticlesApp {

    public static void main(String[] args) {
        SpringApplication.run(NewsArticlesApp.class, args);
    }

}
