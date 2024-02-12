FROM openjdk:17-alpine

WORKDIR /usr/app

COPY target/rinha-backend-2024-q1-0.1.jar rinha-backend-2024-q1-0.1.jar
RUN chmod +x rinha-backend-2024-q1-0.1.jar

#ENV BANCO 172.17.0.2

EXPOSE 8080

CMD ["java", "-jar", "rinha-backend-2024-q1-0.1.jar"]
