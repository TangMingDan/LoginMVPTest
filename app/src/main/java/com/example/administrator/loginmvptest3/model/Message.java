package com.example.administrator.loginmvptest3.model;

public class Message {
    private String person;
    private int imgId;
    private String content;
    private String time;

    public Message(String person, int imgId, String content, String time) {
        this.person = person;
        this.imgId = imgId;
        this.content = content;
        this.time = time;
    }

    public Message() {
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
