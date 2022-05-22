package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    public void add_instantiatesCorrectly_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        assertEquals(true, users instanceof Users);
    }

    @Test
    public void findById_instantiatesCorrectly_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        assertEquals(true, users instanceof Users);
    }

    @Test
    public void update_instantiatesCorrectly_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        assertEquals(true, users instanceof Users);
    }

    @Test
    public void deleteById_instantiatesCorrectly_true() {
        Users users = new Users("name", "rank", "staffRole", 1);
        assertEquals(true, users instanceof Users);
    }


}