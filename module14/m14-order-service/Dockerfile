FROM arm64v8/openjdk:17

ARG jar_name=m14-order-service-CURRENT.jar

COPY target/$jar_name /usr/local/$jar_name

WORKDIR /usr/local/

RUN ["ls", "."]

RUN ["pwd"]

CMD ["java", "-jar", "m14-order-service-CURRENT.jar"]