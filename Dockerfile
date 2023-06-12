FROM openjdk:17

EXPOSE 8080

LABEL maintainer = "ernstBonn"

ADD backend/target/cratego.jar cratego.jar

CMD [ "sh", "-c", "java -jar /cratego.jar" ]




