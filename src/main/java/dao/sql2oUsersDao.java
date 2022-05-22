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
    public  void add(Users user) {
        String sql = "INSERT INTO users (name,rank,staffRole,dept_id) VALUES (:name, :rank, :staffRole, :dept_id)";
        String sql2 = "SELECT * from departments WHERE id=:dept_id";
        try (Connection conn = DB.sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .addParameter("name", user.getName())
                    .addParameter("rank", user.getRank())
                    .addParameter("staffRole", user.getStaffRole())
                    .addParameter("dept_id", user.getDept_id())
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

    public List<Users>  getAllNews(int i) {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    public void clearAll() {
        String sql = "DELETE FROM users";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(sql).executeUpdate();
        }
    }

    public void update(int id, String name2, String rank2, String staffRole2, int i) {
        String sql = "UPDATE users SET name = :name, rank = :rank, staffRole = :staffRole, dept_id = :dept_id WHERE id = :id";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name2)
                    .addParameter("rank", rank2)
                    .addParameter("staffRole", staffRole2)
                    .addParameter("dept_id", i)
                    .executeUpdate();
        }
    }

    public void addUser(Users user) {
        String sql = "INSERT INTO users (name,rank,staffRole,dept_id) VALUES (:name, :rank, :staffRole, :dept_id)";
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
}
