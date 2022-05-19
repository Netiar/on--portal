package dao;

import models.Users;

public interface UsersDao {
    //CRUD
    void add(Users user);

    Users findById(int id);

    Users findByName(String name);

    void update(int id, Users user);

    void deleteById(int id);

    void deleteByName(String name);

    //Other methods



}
