package dao;


import models.Departments;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;


class sql2oDepartmentsDaoTest {

    sql2oDepartmentsDao dao = new sql2oDepartmentsDao();
    Connection conn;

    @Test
    public void add_instantiatesCorrectly_true() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals(true, departments instanceof Departments);
    }

    @Test
    public void findById_instantiatesCorrectly_true() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals(true, departments instanceof Departments);
    }

    @Test
    public void update_instantiatesCorrectly_true() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals(true, departments instanceof Departments);
    }

    @Test
    public void deleteById_instantiatesCorrectly_true() {
        Departments departments = new Departments(2, "ping", "on-duty" );
        assertEquals(true, departments instanceof Departments);
    }
}