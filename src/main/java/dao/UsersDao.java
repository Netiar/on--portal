package dao;

import models.Users;

import java.util.Collection;
import java.util.List;

public interface UsersDao {
    //CRUD
    void add(Users users);


    Users findById(int id);

    Users findByName(String name);

    void update(int id, Users user);

    void deleteById(int id);

    void deleteByName(String name);

    List<Users> getAll();



    //Other methods



}
