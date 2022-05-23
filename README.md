# Organisational News Portal

-By Collins Netia Odinga


## Description

A REST API for querying and retrieving scoped news and information.


## Prerequisites

- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 11 or higher

## Database Set Up
- navigate to  `src/main/resources/sql` to find database
- Type psql
- CREATE DATABASE news_ping; \c news_ping ; 
- \dt to view the tables;-
- \q to quit 
 
###   CREATE DATABASE news_ping; 

        \c news_ping ;
        
         CREATE TABLE users(
         id serial PRIMARY KEY,
         name VARCHAR,
         rank VARCHAR,
         staffRole VARCHAR,
         dept_id INTEGER
         );

         CREATE TABLE departments(
         id serial PRIMARY KEY,
         name VARCHAR,
         description VARCHAR
         );

         CREATE TABLE news(
         id serial PRIMARY KEY,
         title VARCHAR,
         content VARCHAR,
         userid INTEGER,
         departmentid INTEGER
);

## Technologies Used

- Java v11
- Gradle
- Spark Framework
- CSS (Bootstrap)
- JUnit v4.12
- Jacoco Plugin
- postgresql


## Setup Installations Requirements
* To run the application, in your terminal:

    1. Clone or download the Repository
    2. cd into directory then run `cd news-portal`
    3. Rebuild the Project Using Intellij IDEA or ...
    4. Open terminal command line then navigate to the root folder of the application.
    5. Run `gradle run` command.
    6. Navigate to `http://localhost:4567/` in your browser.


### Development

Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request on GitHub



##  list of sample data endpoints.
##  Departments.

### Request

`GET /departments`

    curl -i -H 'Accept: application/json' http://localhost:0.0.0.0:4567//departments

### Response

     {
        "status": 200,
        "message": "Success",
         "data": [
           []
         ]
    }

### Request

`POST /departments/new`

    curl -i -H 'Accept: application/json' -d 'name=Foo&status=new' http://localhost:4567/departments/new

### Response

    {
    "status": 201,
    "message": "Department Added Successfully!",
    "data": {}
    }

## Get departmental news

### Request

`GET /departments/news

    curl -i -H 'Accept: application/json' http://localhost:0.0.0.0:4567/departments/news

### Response

        {
         "status": 200,
         "message": "Success",
         "data": [
            []
          ]
         }

## Get new departmental news

### Request

`post //departments/news/new`

    curl -i -H 'Accept: application/json' http://localhost:4567/departments/news/new

### Response

     {
    "status": 201,
    "message": "News Added to department Successfully!",
    "data": {}
    }

   

## News with error

### Request

`POST //users/new`

    curl -i -H 'Accept: application/json' -d 'name=Bar&junk=rubbish' http://localhost:4567/users/new

### Response

    {
    "status": 404,
    "message": "Invalid Request",
    "data": {}
    }

### Request

`get/users/new`

    curl -i -H 'Accept: application/json' -d 'name=Bar&junk=rubbish' http://localhost:4567/users

### Response

    {
    "status": 404,
    "message": "Invalid Request",
    "data": {}
    }

## delete department

### Request

`de //users

    curl -i -H 'Accept: application/json' -d 'name=Bar&junk=rubbish' http://localhost:4567/users/new

### Response

    {
    "status": 404,
    "message": "Invalid Request",
    "data": {}
    }




*MIT*
Copyright (c) 2022 **Collins Netia Odinga**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.