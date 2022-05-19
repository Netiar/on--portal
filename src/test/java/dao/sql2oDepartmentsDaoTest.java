package dao;


import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oDepartmentsDaoTest {

    sql2oDepartmentsDao dao = new sql2oDepartmentsDao();
    Connection conn;

    @Before
    void setUp() throws Exception {

        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createh2.sql'","","");
        conn = DB.sql2o.open();
    }

    @After
    void tearDown() throws Exception {
        conn.close();
    }

    @Test
     void add() {

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