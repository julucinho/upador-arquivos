FROM openjdk:11
COPY target/upador-arquivo-plugins-1.0-jar-with-dependencies.jar ./app.jar
COPY target/classes/desenho.png ./desenho.png

ENTRYPOINT ["java", "-jar", "app.jar"]