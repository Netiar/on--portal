import com.google.gson.Gson;
import dao.DB;
import dao.sql2oDepartmentsDao;
import models.Departments;
import org.sql2o.Sql2o;
import response.ResponseArray;
import response.ResponseObject;

import java.util.Collections;
import java.util.List;

import static spark.Spark.*;
public class App {

    public static  void main(String[] args) {
        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createh2.sql'","","");
        sql2oDepartmentsDao departmentsDao = new sql2oDepartmentsDao();

        post("/departments/new",(request, response) -> {
            Gson gson = new Gson();
            Departments departments = gson.fromJson(request.body(), Departments.class);
            departmentsDao.add(departments);
            ResponseObject responseObject = new ResponseObject(201,"Department Added Successfully!");
            responseObject.setData(new Object());
            response.status(201);
            response.type("application/json");
            return gson.toJson(responseObject);
        });

        get("/departments",(request, response) -> {
            Gson gson = new Gson();
            List<Departments> list = departmentsDao.getAll();
            ResponseArray responseArray = new ResponseArray(200,"Success");
            responseArray.setData(Collections.singletonList(list));
            response.status(200);
            response.type("application/json");
            return gson.toJson(responseArray);
        });





//        after((req, res) ->{
//            res.type("application/json");
//        });
    }

}
