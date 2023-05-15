FROM amazoncorretto:17

MAINTAINER Emibroggi

COPY target/back-0.0.1-SNAPSHOT.jar back-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/back-0.0.1-SNAPSHOT.jar"]
