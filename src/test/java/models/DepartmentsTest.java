package models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {

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
