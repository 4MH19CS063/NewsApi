package com.example.newsapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObjectModel {
    @SerializedName("articles")
    List<Articles> list;
    @SerializedName("status")
    String status;
    @SerializedName("totalResults")
    int totalResults;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Articles> getList() {
        return list;
    }
}
class Articles{
    @SerializedName("title")
    String title;
    @SerializedName("content")
    String content;
    @SerializedName("description")
    String description;
    @SerializedName("source")
    Source source;
    @SerializedName("publishedAt")
    String publishedAt;
    @SerializedName("urlToImage")
    String urlToImage;
    @SerializedName("url")
    String url;
    @SerializedName("author")
    String author;

    public Articles(String title, String content, String description, Source source, String publishedAt, String urlToImage, String url, String author) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.source = source;
        this.publishedAt = publishedAt;
        this.urlToImage = urlToImage;
        this.url = url;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public Source getSource() {
        return source;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }
}
class  Source{
    @SerializedName("name")
    String name;
    public Source(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
