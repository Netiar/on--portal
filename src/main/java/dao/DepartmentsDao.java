package dao;

import models.Departments;

public interface DepartmentsDao {
    //CRUD
    void add(Departments department);

    Departments findById(int id);

    void update(int id, Departments department);

    void deleteById(int id);








}
