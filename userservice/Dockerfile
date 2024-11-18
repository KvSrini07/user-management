FROM adoptopenjdk/openjdk11:alpine-jre
ADD build/libs/*.jar userms.jar
EXPOSE 5002
ENTRYPOINT ["java","-jar","userms.jar"]

