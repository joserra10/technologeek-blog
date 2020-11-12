FROM openjdk:12
VOLUME /tmp
EXPOSE 8891
ADD ./build/libs/technologeek-config-0.0.1-SNAPSHOT.jar technologeek-config.jar
ENTRYPOINT ["java", "-jar", "/technologeek-config.jar"]