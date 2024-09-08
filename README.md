## 🎯Liv2train_registry

## Objective

Liv2Train is a Spring Boot application designed as a registry for government-funded training centers. The application provides APIs to create and retrieve information about training centers, with a focus on data validation and efficient data management.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Lombok

## Features
- Create a new training center with various attributes.
- Retrieve a list of all training centers, with optional filtering by center name or course offered.
- Validations for mandatory fields and proper error handling.
- Use of an embedded address model to store address information.

## Package Structure and Class:
![structure](https://github.com/user-attachments/assets/1f59aa49-e9d0-4d4e-85a3-cd025c6e89b8)

## Run Successfully:
![Screenshot (123)](https://github.com/user-attachments/assets/7d70f8da-f28d-4a83-9b9d-b87631ebf1ff)


### POST /training-centers
Create a new training center.

**Request Body:**
```json
{
    "centerName": "Masai School Center",
    "centerCode": "Masai1234567",
    "address": {
        "detailedAddress": "Incubex HSR21, 5th Main Rd sector 6 HSR Layout Bengaluru, Karnataka",
        "city": "Bengaluru",
        "state": "Karnataka",
        "pincode": "560034"
    },
    "studentCapacity": 200,
    "coursesOffered": [
        "Java Programming",
        "Data Science",
        "Web Development"
    ],
    "contactEmail": "carrier@masaischool.com",
    "contactPhone": "1234567890"
}
```

**Request Body:**
```json

{
    "centerName": "Masai School Center",
    "centerCode": "Masai1234567",
    "address": {
        "detailedAddress": "Incubex HSR21, 5th Main Rd sector 6 HSR Layout Bengaluru, Karnataka",
        "city": "Bengaluru",
        "state": "Karnataka",
        "pincode": "560034"
    },
    "studentCapacity": 200,
    "coursesOffered": [
        "Java Programming",
        "Data Science",
        "Web Development"
    ],
    "createdOn": "2024-09-08T12:27:05.136201Z",
    "contactEmail": "carrier@masaischool.com",
    "contactPhone": "1234567890"
}

```
## Create new training_centers By Postman! ==
![Capture5](https://github.com/user-attachments/assets/09ac710a-d51b-4c29-88c0-1afcf2cff064)

## GET /training-centers

- Retrieve a list of all training centers, with optional filtering.
### Query Parameters:

  - centerName (optional): Filter by center name.
  - course (optional): Filter by course offered.

### Filter by center name:
![centerName](https://github.com/user-attachments/assets/b09ad343-84eb-4105-b209-f1fb0ef655ec)
### Filter by course offered:
![course](https://github.com/user-attachments/assets/70c37e0e-c0a3-4986-9104-2364672b10f4)
### Get all centers:
![all](https://github.com/user-attachments/assets/46e33261-b6d6-41a3-8a74-a5250b8839fc)

## Validation
- Mandatory fields are validated using annotations such as @NotBlank, @Size, @Email, and @Pattern..
- The application uses Spring's @ExceptionHandler to handle validation errors gracefully.

### Example:
![validation](https://github.com/user-attachments/assets/17231207-869c-4c20-a329-51a8b1251cfc)


## Database Configuration
- The application connects to a MySQL database. Configure the database properties in application.properties:

**Look like:**
```

spring.application.name=Liv2train_registry
#changing the server port
server.port=8080
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/TrainingCenters
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER


```
### In DataBase data look like:
![table](https://github.com/user-attachments/assets/fe9a1a7a-05e6-4f8f-ac1f-26c88275ea84)

## Thank You!
Thank you for exploring the **Liv2Train Registry** project! We hope you find this project useful and insightful. Your feedback and contributions are always welcome, so feel free to reach out or submit improvements. 

Happy coding! 🚀
