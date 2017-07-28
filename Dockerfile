FROM openjdk:8-jre-alpine
EXPOSE 9090
COPY build/distributions/watch.tar /opt/
RUN tar -xvf /opt/watch.tar -C /opt/
WORKDIR /opt/watch/bin
ENTRYPOINT ["./watchdog"]