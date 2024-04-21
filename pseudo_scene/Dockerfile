FROM anapsix/alpine-java
EXPOSE 8888
#ADD target/pseudo_scene.jar pseudo_scene.jar
COPY /target/pseudo_scene.jar /home/pseudo_scene.jar
ENTRYPOINT ["java", "-jar", "/pseudo_scene.jar"]
