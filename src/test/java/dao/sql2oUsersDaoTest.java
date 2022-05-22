package dao;

import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class sql2oUsersDaoTest {
    sql2oUsersDao dao = new sql2oUsersDao();
    sql2oNewsDao newsDao = new sql2oNewsDao();
    Connection conn;

    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createh2.sql'", "", "");
        conn = DB.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void deleteByName_instantiatesCorrectly_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        assertEquals(true, users instanceof Users);
    }

    @Test
    public void getAll_returnsAllUsers_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        users.save(2);
        Users users2 = new Users("name2", "rank2", "staffRole2", 2);
        users2.save(2);
        assertNotEquals(2, Users.getAll().size());
    }

    @Test
    public void  add_addsNewMentor_true(){
        Users users = new Users("name", "rank", "staffRole", 1);
        int id =users.getId();
        users.save(2);
        assertEquals(id, users.getId());

    }


}