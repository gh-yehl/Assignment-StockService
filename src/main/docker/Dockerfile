FROM java:8
VOLUME /tmp

ADD exchange-service-1.0-SNAPSHOT.jar exchange-service.jar
ENTRYPOINT ["java","-Xms200m","-Xmx300m","-jar","/exchange-service.jar"]