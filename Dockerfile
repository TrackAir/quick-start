FROM 10.0.1.28:5000/jdk8_image:V1.0

MAINTAINER little "0211@wisefly.cn"

RUN mkdir -p /opt/server
ADD wisefly-workflow-web/target/wisefly-workflow-web-1.0-SNAPSHOT.jar /opt/server

WORKDIR /opt/server

ENTRYPOINT ["java","-jar","-Xms512m","-Xmx512m","-Dfile.encoding=utf-8","-Ddruid.mysql.usePingMethod=false","wisefly-workflow-web-1.0-SNAPSHOT.jar"]
