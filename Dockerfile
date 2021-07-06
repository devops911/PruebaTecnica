# FROM openjdk:8-jre-slim
# RUN mkdir /app
# USER root
# WORKDIR app
# EXPOSE 8080
# # Copy war file
# COPY /target/swagger-spring-1.0.0.jar /swagger-spring-1.0.0.jar 

# # run the app
# CMD ["/usr/local/openjdk-8/bin", "-jar", "/swagger-spring-1.0.0.jar "]

FROM java:8
WORKDIR /
COPY /target/swagger-spring-1.0.0.jar swagger-spring-1.0.0.jar 
EXPOSE 8080
CMD java - jar swagger-spring-1.0.0.jar

