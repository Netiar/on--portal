package dao;


import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oUsersDao implements UsersDao {
    private Sql2o sql2o;


    public void Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users user) {
        String sql = "INSERT INTO users (name,rank,staffRole,dept_id) VALUES (:name, :rank, :staffRole, :dept_id)";
        String sql2 = "SELECT * from departments WHERE id=:dept_id";
        try (Connection conn = DB.sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Users findById(int id) {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }
    }

    @Override
    public Users findByName(String name) {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("SELECT * FROM users WHERE name = :name")
                    .addParameter("name", name)
                    .executeAndFetchFirst(Users.class);
        }
    }

    @Override
    public void update(int id, Users user) {
        String sql = "UPDATE users SET name = :name, rank = :rank, staffRole = :staffRole, dept_id = :dept_id WHERE id = :id";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(sql)
                    .bind(user)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteByName(String name) {
        String sql = "DELETE FROM users WHERE name = :name";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("name", name)
                    .executeUpdate();
        }
    }

    @Override
    public List<Users> getAll() {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }
}
