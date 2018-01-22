package com.example.jason.sagy;

/**
 * Created by goa on 22/1/18.
 */

public class Model {

    private String title;
    private String content;

    public Model(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
