FROM openjdk:12
VOLUME /tmp
ADD ./build/libs/blog-data-access-0.0.1-SNAPSHOT.jar blog-data-access.jar
ENTRYPOINT ["java", "-jar", "/blog-data-access.jar"]