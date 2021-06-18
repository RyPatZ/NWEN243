FROM openjdk:8
COPY *.java /usr/src/jokes/
WORKDIR /usr/src/jokes
RUN javac JokerServer.java
EXPOSE 5000
CMD ["java", "JokerServer"]