FROM openjdk:8-jre-slim
RUN mkdir /app
WORKDIR app
EXPOSE 8080
# Copy war file
COPY /target/swagger-spring-1.0.0.jar /swagger-spring-1.0.0.jar 

# run the app
CMD ["/usr/bin/java", "-jar", "/swagger-spring-1.0.0.jar "]





