package dao;

import models.Departments;
import org.sql2o.Connection;

import java.util.List;

public class sql2oDepartmentsDao  implements DepartmentsDao{
    @Override
    public void add(Departments department) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", department.getName())
                    .addParameter("description", department.getDescription())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }
    }

    @Override
    public Departments findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM departments WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void update(int id, Departments department) {
        String sql = "UPDATE departments SET name = :name, description = :description WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", department.getName())
                    .addParameter("description", department.getDescription())
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public List<Departments> getAllObject() {
        String sql = "SELECT * FROM departments";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public List<Departments> getAll() {
        String sql = "SELECT * FROM departments";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }



}
