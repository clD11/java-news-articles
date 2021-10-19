package com.news_articles.data.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleDatabase {

    private static final Map<String, Object> DATABASE = new HashMap<>();

    public void insert(String id, Object data) {
        if (DATABASE.containsKey(id)) {
            throw new InsertRowException("simple database: could not insert row");
        }
        DATABASE.put(id, data);
    }

    public Object select(String id) {
        if (!DATABASE.containsKey(id)) {
            throw new NoRowException("simple database: could not select row");
        }
        return DATABASE.get(id);
    }
}
