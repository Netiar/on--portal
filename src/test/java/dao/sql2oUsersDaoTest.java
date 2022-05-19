package dao;

import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;



import static org.junit.jupiter.api.Assertions.*;

class sql2oUsersDaoTest {
    sql2oUsersDao dao = new sql2oUsersDao();
    sql2oNewsDao newsDao = new sql2oNewsDao();
    Connection conn;

    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createH2.sql'", "", "");
        conn = DB.sql2o.open();
     }
     @After
        public void tearDown() throws Exception {
            conn.close();
        }



    @Test
    public void add() {
        Users user = new Users("name", "rank", "staffRole", 1);
        dao.add(user);
        assertEquals(1, user.getId());



    }



    @Test
     void getAll() {

    }

    @Test
    void findById() {

    }

    @Test
    void update() {

    }

    @Test
    void deleteById() {

    }


}
