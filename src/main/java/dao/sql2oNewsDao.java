package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class sql2oNewsDao implements NewsDao {
    private Sql2o sql2o;

    public void Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (id, title, content, author, date) VALUES (:id, :title, :content, :author, :date)";
        try (org.sql2o.Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }
    }

    @Override
    public News findById(int id) {
        String sql = "SELECT * FROM news WHERE id = :id";
        try (org.sql2o.Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public News findByTitle(String title) {
        String sql = "SELECT * FROM news WHERE title = :title";
        try (org.sql2o.Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("title", title)
                    .executeAndFetchFirst(News.class);
        }
    }


    @Override
    public News findByTitle() {
            try (Connection con = DB.sql2o.open()) {
                String sql = "SELECT * FROM articles";
                return (News) con.createQuery(sql).executeAndFetch(sql2oNewsDao.class);
            }
    }

    @Override
    public void update(int id, News news) {
        String sql = "UPDATE news SET title = :title, content = :content, WHERE id = :id";
        try (org.sql2o.Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("title", news.getTitle())
                    .addParameter("content", news.getContent())
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM news WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public void deleteByTitle(String title) {
        String sql = "DELETE FROM news WHERE title = :title";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("title", title)
                    .executeUpdate();
        }

    }


}