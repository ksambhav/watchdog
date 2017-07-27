FROM openjdk:8-jre-slim
EXPOSE 8080
COPY build/distributions/watch.tar /opt/
RUN tar -xvf /opt/watch.tar -C /opt/
WORKDIR /opt/watch/bin
ENTRYPOINT ["./watchdog"]