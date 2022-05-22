package dao;

import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class sql2oNewsDaoTest {

    sql2oNewsDao dao = new sql2oNewsDao();
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
    public void setId() {
        News news = new News("", "ping",1 ,1);
        news.setId(3);
        assertEquals(3, news.getId(2));
    }

    @Test
    public void getTitle() {
        News news = new News("", "ping",1 ,1);
        news.getTitle(news);
        assertEquals("", news.getTitle(news));
    }

    @Test
    public void setTitle() {
        News news = new News("", "ping",1 ,1);
        news.setTitle("pong");
        assertEquals("pong", news.getTitle(news));
    }

    @Test
    public void getContent() {
        News news = new News("", "ping",1 ,1);
        news.getContent("ping");
        assertEquals("ping", news.getContent("ping"));
    }

    @Test
    public void setContent() {
        News news = new News("", "ping",1 ,1);
        news.setContent("pong");
        assertEquals("pong", news.getContent("ping"));
    }

}