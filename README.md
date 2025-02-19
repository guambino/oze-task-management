# oze-task-management
Oze Task Management Services

# Build the services 
mvn clean install -U

# Run the services
mvn -pl oze-task-management-web spring-boot:run

# Service URL ( Swagger)
http://localhost:8080/swagger-ui/index.html

# Generate keys onto src/main/resources/jwt
openssl genpkey -algorithm RSA -out oze.key -outform PEM
openssl rsa -pubout -in oze.key -out oze.pub

# Testing the services
# 1. Register User
   POST: http://localhost:8080/task/auth/user/register
   Request Body:
   {
        "firstName": "Ivan",
        "lastName": "Guambe",
         "email": "ivan.guambe@getoze.com",
         "password": "OzeDeveloper80#"
   }