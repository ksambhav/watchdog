FROM openjdk:8-jre-alpine
EXPOSE 9090
WORKDIR /opt/watch/
ADD ["build/libs/watchdog.jar","application.yml", "./"]
ENTRYPOINT ["java","-jar","watchdog.jar"]