import com.google.gson.Gson;
import dao.DB;
import org.sql2o.Connection;

public class App {

    public static  void main(String[] args) {

        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Gson gson = new Gson();
        Connection conn;

        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        newsDao = new Sql2oNewsDao(DB.sql2o);
        userDao = new Sql2oUserDao(DB.sql2o);
        conn = DB.sql2o.open();

    }
  // Still working on the app
}
