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
# 2. List all Task Types