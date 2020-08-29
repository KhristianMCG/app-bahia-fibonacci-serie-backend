# Getting Started

### Reference Documentation
This service is calculate fibonacci serie that is informed as limitOfSerie. The result is exposed way API REST and can be consumed for third party software or for frontend services, that can print result in a single page.

### Run Application
Select BahiaFibonacciSerieApplication and Run As java application or spring-boot-app. This will serve a Tomcat Server
in localhost:8080.

### Getting Fibonaccie Serie
There is a servlet controller, that will show serie based on parameter when we calling API rest. For show the serie simple call
http://localhost:8080/api/getFibonacciSerie/{limitOfSerie}.

### Swagger API Specification
Swagger2 is integrated with this service, allowing check API specification in easy and smart way. For access
please follow the link http://localhost:8080/swagger-ui/.

