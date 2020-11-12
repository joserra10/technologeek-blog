FROM openjdk:12
VOLUME /tmp
ADD ./target/blog-oauth-server-0.0.1-SNAPSHOT.jar blog-oauth-server.jar
ENTRYPOINT ["java", "-jar", "/blog-oauth-server.jar"]