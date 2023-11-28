# BMI Calculator Application

This Spring Boot application calculates Body Mass Index (BMI) based on user input for weight and height.

## Introduction

The BMI Calculator Application is a simple Spring Boot application designed to calculate the BMI of users. It follows the MVC (Model-View-Controller) pattern, consisting of the following modules:

## Modules

- **BmiApplicationController:** Handles HTTP requests, interacts with the service layer.
- **BmiService:** Contains the business logic for BMI calculation.
- **BmiBean:** Represents the BMI entity with attributes such as weight, height, and BMI value.
- **BmiCalculatorApplication:** Entry point for the Spring Boot application.

# Getting Started

To get started with the BMI Calculator Application, clone the repository and follow the build and run instructions below.

## Clone Repository 

```
git clone https://github.com/Seshenya-Weerasinghe/bmi-app.git

cd bmi-app
```

The application will be accessible locally at localhost:8080

Configure the MySQL properly before running the application.

## API Endpoints

Calculate BMI and store data in the db:

```
POST /calculate
```
```
{
    "name": "John Doe",
    "height": 157,
    "weight": 47,
    "bmi_value": 0.0019,
}
```

Get the BMI List:
```
GET /
```

Get the BMI details by Id:

```
GET /result/{id}
```
Example:
```
/result/222
```

## Deployement 
This application is deployed on Azure and it is accessible at https://springboot-bmi.azurewebsites.net



