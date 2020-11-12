FROM openjdk:12
VOLUME /tmp
EXPOSE 8889
ADD ./target/blog-zuul-server-0.0.1-SNAPSHOT.jar blog-zuul-server.jar
ENTRYPOINT ["java", "-jar", "/blog-zuul-server.jar"]