package models;

import java.util.Objects;

public class News {
    private int id;
    private String title;
    private String content;
    private int userId;
    private int departmentId;

    public News(String title, String content, int userId, int departmentId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.departmentId = departmentId;
    }

    public static News newNews(String title, String content, int i, int i1) {
        return new News(title, content, i, i1);
    }

    public int getId(int i) {
        return id;
    }

    public String getTitle(News news) {
        return title;
    }

    public String getContent(String ping) {
        return content;
    }

    public int getUserId(int i) {
        return userId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && userId == news.userId && departmentId == news.departmentId && title.equals(news.title) && content.equals(news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, userId, departmentId);
    }
}
