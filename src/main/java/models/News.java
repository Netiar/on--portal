package models;

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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
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
}
