package dao;

import models.News;

import java.awt.*;

public interface NewsDao {
    //CRUD
    void add(News news);

    News findById(int id);

    News findByTitle(String title);

    News findByTitle();

    void update(int id, News news);

    void deleteById(int id);

    void deleteByTitle(String title);



    List getAll();

    //Other methods

}
