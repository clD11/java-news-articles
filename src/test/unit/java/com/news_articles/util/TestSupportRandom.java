package com.news_articles.util;

import java.util.Random;
import java.util.UUID;

public class TestSupportRandom {

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static boolean randomBoolean() {
        return new java.util.Random().nextBoolean();
    }
}
