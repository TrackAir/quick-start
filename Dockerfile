FROM openjdk:8

MAINTAINER little "track"

RUN mkdir -p /opt/server
ADD quick-start-0.0.1-SNAPSHOT.jar /opt/server

WORKDIR /opt/server

EXPOSE 8081

ENTRYPOINT ["java","-jar","-Xms512m","-Xmx512m","-Dfile.encoding=utf-8","-Ddruid.mysql.usePingMethod=false","quick-start-0.0.1-SNAPSHOT.jar"]
