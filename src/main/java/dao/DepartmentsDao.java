package dao;

import javafx.beans.binding.Bindings;
import models.Departments;

import java.util.Collection;
import java.util.List;

public interface DepartmentsDao {
    //CRUD
    void add(Departments department);

    Departments findById(int id);

    void update(int id, Departments department);

    void deleteById(int id);


    List<Departments> getAllObject();

    List<Departments> getAll();
}
