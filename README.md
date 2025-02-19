# oze-task-management
Oze Task Management Services

# Build the services 
mvn clean install -U

# Run the services
mvn -pl oze-task-management-web spring-boot:run

# Service URL ( Swagger - API Specifications )
http://localhost:8080/swagger-ui/index.html

# Generate keys onto src/main/resources/jwt
openssl genpkey -algorithm RSA -out oze.key -outform PEM
openssl rsa -pubout -in oze.key -out oze.pub

# Database
schema : resources/schema.sql
pre populated data: resources/data.sql

# Testing the services with Postman
# 1 Unprotected Endpoints
# 1.1 Register User
   POST: http://localhost:8080/task/auth/user/register
   Request Body:
   {
        "firstName": "Ivan",
        "lastName": "Guambe",
         "email": "ivan.guambe@getoze.com",
         "password": "OzeDeveloper80#"
   }
   
# 1.2 The login if successfully will return the token (valid for 15m - configurable ) need to call the protected services
   POST: http://localhost:8080/task/auth/user/login
   Request Body:
   {
        "username": "ivan.guambe@getoze.com",
        "password": "OzeDeveloper80#"
   }
# ================================================================================================   
# 2. Protected Endpoints
# 2.1 List all Task Types
   GET: http://localhost:8080/task/type
   Headers: Authorization: Bearer <JWT_TOKEN>
   
# 2.2 Register Task
# 2.2.1 Type Bug
   POST: http://localhost:8080/task/register
   Headers: Authorization: Bearer <JWT_TOKEN>
   Request Body:
   {
        "title": "Listing tasks is Empty.",
        "description": "The Listing of tasks is coming up empty when there are tasks on the DB.",
        "taskType": {
            "taskTypeId": "TASK_TYPE_BUG",
            "description": "Bug"
        }
   }

# 2.2.2 Type User Story
   POST: http://localhost:8080/task/register
   Headers: Authorization: Bearer <JWT_TOKEN>
   Request Body:
   {
        "title": "As I user I want to be able to authenticate",
        "description": "Any user with credentials should be able to authenticate",
        "taskType": {
            "taskTypeId": "TASK_TYPE_STORY",
            "description": "Story"
         }
  }
# 2.3 List All Tasks
 GET http://localhost:8080/task
 Headers: Authorization: Bearer <JWT_TOKEN>

# 2.4 Update 
# 2.4.1 Update Task without completion date
  PUT: http://localhost:8080/task/update/<taskId>
  Headers: Authorization: Bearer <JWT_TOKEN>
  Request Body:
  {
        "title": "As I user I want to be able to authenticate",
        "description": "Any user with credentials should be able to authenticate",
        "taskType": {
            "taskTypeId": "TASK_TYPE_STORY",
            "description": "Story"
        },
        "taskComment": {
        "comment": "Development has started"
       }
  }

# 2.4.2 Update Task with completion date
  PUT: http://localhost:8080/task/update/<taskId>
  Headers: Authorization: Bearer <JWT_TOKEN>
  Request Body:
  {
        "title": "As I user I want to be able to authenticate",
        "description": "Any user with credentials should be able to authenticate",
        "taskType": {
            "taskTypeId": "TASK_TYPE_STORY",
            "description": "Story"
         },
        "completionDate": "2025-02-18",
        "taskComment": {
        "comment": "The story is done"
        }
  }

# 2.5 Delete
   DELETE: http://localhost:8080/task/delete/<taskId>
   Headers: Authorization: Bearer <JWT_TOKEN>