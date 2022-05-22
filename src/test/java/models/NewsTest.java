package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @Test
    public void add_instantiatesCorrectly_true() {
        News news = new News("", "ping", 1, 1 );
        assertEquals(true, news instanceof News);
    }

    @Test
    public void findById_instantiatesCorrectly_true() {
        News news = new News("", "ping", 1, 1 );
        assertEquals(true, news instanceof News);
    }

    @Test
    public void update_instantiatesCorrectly_true() {
        News news = new News("", "ping", 1, 1 );
        assertEquals(true, news instanceof News);
    }

    @Test
    public void deleteById_instantiatesCorrectly_true() {
        News news = new News("", "ping", 1, 1 );
        assertEquals(true, news instanceof News);
    }

}