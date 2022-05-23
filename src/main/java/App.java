
import com.google.gson.Gson;
import dao.DB;
import dao.sql2oDepartmentsDao;
import dao.sql2oNewsDao;
import dao.sql2oUsersDao;
import exceptions.ApiException;

import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import response.ResponseArray;
import response.ResponseObject;
import spark.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static spark.Spark.*;
public class App {

    public static  void main(String[] args) {
        DB.sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/createh2.sql'","","");
        sql2oDepartmentsDao departmentsDao = new sql2oDepartmentsDao();
        sql2oNewsDao newsDao = new sql2oNewsDao();
        sql2oUsersDao usersDao = new sql2oUsersDao();


        //add new department
        post("/departments/new",(request, response) -> {
            Gson gson = new Gson();
            Departments departments = gson.fromJson(request.body(), Departments.class);
            departmentsDao.add(departments);
            ResponseObject responseObject = new ResponseObject(201,"Department Added Successfully!");
            responseObject.setData(new Object());
            System.out.println();
            response.status(201);
            response.type("application/json");
            return gson.toJson(responseObject);
        });

        //get all departments
        get("/departments",(request, response) -> {
            Gson gson = new Gson();
            List<Departments> list = departmentsDao.getAll();
            ResponseArray responseArray = new ResponseArray(200,"Success");
            responseArray.setData(Collections.singletonList(list));
            response.status(200);
            response.type("application/json");
            return gson.toJson(responseArray);
        });

        //add news department
        post("/departments/news/new",(request, response) -> {
            Gson gson = new Gson();
            Departments departments = gson.fromJson(request.body(), Departments.class);
            departmentsDao.add(departments);
            ResponseObject responseObject = new ResponseObject(201,"News Added to department Successfully!");
            responseObject.setData(new Object());
            response.status(201);
            response.type("application/json");
            return gson.toJson(responseObject);
        });

        //get all departmental news
        get("/departments/news",(request, response) -> {
            Gson gson = new Gson();
            List<Departments> list = departmentsDao.getAll();
            ResponseArray responseArray = new ResponseArray(200,"Success");
            responseArray.setData(Collections.singletonList(list));
            response.status(200);
            System.out.println();
            response.type("application/json");
            return gson.toJson(responseArray);
        });

        get("/departments_id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int id = Integer.parseInt(req.params("id")); //get the id from the URL
            Departments departmentToFind = departmentsDao.findById(id); //find the department with the id
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            Gson gson = new Gson();
            return gson.toJson(departmentToFind);
        });

        //add user
        post("/users/new",(request, response) -> {
            Gson gson = new Gson();
            Users users = gson.fromJson(request.body(), Users.class);
            usersDao.add(users);
            ResponseObject responseObject = new ResponseObject(201,"User Added Successfully!");
            responseObject.setData(new Object());
            response.status(201);
            response.type("application/json");
            return gson.toJson(responseObject);
        });

        //get all users
        get("/users",(request, response) -> {
            Gson gson = new Gson();
            List<Users> list = usersDao.getAll();
            ResponseArray responseArray = new ResponseArray(200,"Success");
            responseArray.setData(Collections.singletonList(list));
            response.status(200);
            response.type("application/json");
            return gson.toJson(responseArray);
        });

        //delete department
        delete("/departments_id",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Departments departmentToDelete = departmentsDao.findById(id);
            if (departmentToDelete == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", request.params("id")));
            }
            departmentsDao.deleteById(id);
            ResponseArray responseArray = new ResponseArray(200,"Department Deleted Successfully!");
            responseArray.setData(new ArrayList<>(Collections.singletonList(departmentToDelete)));
            response.status(200);
            response.type("application/json");
            Gson gson = new Gson();
            return gson.toJson(responseArray);
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }

}
