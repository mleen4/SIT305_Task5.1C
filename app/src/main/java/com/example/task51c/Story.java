package com.example.task51c;

public class Story {
    private String title, body;
    private Integer id, image;

    public Story(String title, String body, Integer id, Integer image) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getId() {
        return id;
    }

    public Integer getImage() {
        return image;
    }

}
