package dao;


import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;


class sql2oDepartmentsDaoTest {

    sql2oDepartmentsDao dao = new sql2oDepartmentsDao();
    Connection conn;

    @Before
    public void setup() throws Exception {
        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createh2.sql'","","");
        conn = DB.sql2o.open();
    }
    @After

    public void tearDown() throws Exception {
        conn.close();
    }


    @Test
    public  void getId() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals(2, departments.getId());
    }

    @Test
    public void setId() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        departments.setId(3);
        assertEquals(3, departments.getId());
    }

    @Test
    public void getName() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals("ping", departments.getName());
    }

    @Test
    public void setName() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        departments.setName("pong");
        assertEquals("pong", departments.getName());
    }

    @Test
    public void getStaffRole() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        departments.getStaffRole("on-duty");
        assertEquals("off-duty", departments.getStaffRole("off-duty"));
    }

    @Test
    public void setStaffRole() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        departments.setStaffRole("off-duty");
        assertEquals("off-duty", departments.getStaffRole("off-duty"));
    }

}

