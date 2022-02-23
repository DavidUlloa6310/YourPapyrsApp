package com.example.yourpapyrs;

import org.json.JSONArray;

import java.io.Serializable;

public class Piece implements Serializable {
    private String authorId;
    private String _id;
    private String title;
    private String text;
    private String author;
    private JSONArray likes;
    private JSONArray flags;

    public Piece() {

    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public JSONArray getLikes() {
        return likes;
    }

    public void setLikes(JSONArray likes) {
        this.likes = likes;
    }

    public JSONArray getFlags() {
        return flags;
    }

    public void setFlags(JSONArray flags) {
        this.flags = flags;
    }
}
