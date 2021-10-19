package com.news_articles.data.persistence;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleDatabase {

    private static final Map<String, Object> DATABASE = new HashMap<>();

    public void save(String id, Object data) {
        if (DATABASE.containsKey(id)) {
            throw new InsertRowException("Could not insert row");
        }
        DATABASE.put(id, data);
    }

    public Object getById(String id) {
        if (!DATABASE.containsKey(id)) {
            throw new NoRowException("Could not select row");
        }
        return DATABASE.get(id);
    }
}
