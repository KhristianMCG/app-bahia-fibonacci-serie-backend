FROM openjdk:8-jdk-alpine

MAINTAINER Cristian Moreno - cristian.moreno@cmtekprojects.com

ADD /target/*.jar fibo-servive-backend.jar

ENTRYPOINT ["java","-jar","fibo-servive-backend.jar"]
