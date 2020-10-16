package com.example.me08;

/**
 * @description:
 * @author: houkeqin

 */
public class NewsListBean {
    private String title;
    private String content;

    public NewsListBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsListBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}