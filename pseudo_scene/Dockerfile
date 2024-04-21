FROM openjdk:19
EXPOSE 8888
#ADD target/pseudo_scene.jar pseudo_scene.jar
COPY /target/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "/pseudo_scene.jar"]
