FROM openjdk:12
VOLUME /tmp
EXPOSE 8762
ADD ./target/blog-eureka-server-0.0.1-SNAPSHOT.jar blog-eureka-server.jar
ENTRYPOINT ["java", "-jar", "/blog-eureka-server.jar"]