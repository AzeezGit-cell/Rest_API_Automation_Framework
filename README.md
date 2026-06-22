# Rest Assured API Automation Framework

## Overview

This project is a scalable API Automation Framework developed using Java, Rest Assured, TestNG, Maven, Apache POI, Extent Reports, and Log4j2. The framework supports CRUD operations, data-driven testing, reporting, logging, and API validation.

---

## Tech Stack

* Java 21
* Rest Assured
* TestNG
* Maven
* Apache POI
* Log4j2
* Extent Reports
* Jackson Databind
* JSON

---

## Framework Features

* REST API CRUD Operations
* Data Driven Testing using Excel
* TestNG Data Providers
* Extent HTML Reporting
* Log4j2 Logging
* Properties File Configuration
* POJO Based Request Payloads
* API Response Validation
* Maven Build Support
* TestNG Suite Execution

---

## Project Structure

src/test/java

├── api_Endpoints
│ ├── Routes.java
│ ├── UserEndPoints.java
│
├── api_payload
│ ├── User.java
│
├── api_test
│ ├── UserTests.java
│ ├── DataDrivenTests.java
│
├── api_utilities
│ ├── ExcelUtility.java
│ ├── DataProviders.java
│ ├── ExtentReportManager.java
│ ├── ExtentListener.java
│ └── Log.java

src/test/resources

├── log4j2.xml
├── routes.properties

testData

└── Rest_API_Data.xlsx

---

## Implemented Scenarios

### User Module

* Create User
* Get User
* Update User
* Delete User

### Data Driven Testing

* Read test data from Excel
* Execute tests using TestNG DataProvider

### Reporting

* Extent HTML Report Generation
* Test Execution Summary

### Logging

* Console Logging
* File Logging using Log4j2

---

## Execution

Run all tests:

mvn clean test

Run TestNG Suite:

testng.xml

---

## Reporting

Extent Reports are generated under:

Reports/

Execution logs are generated under:

logs/

---

## Author

Abdul Azeez Shaik

QA Automation Engineer

Java | Selenium | Rest Assured | TestNG | Maven
