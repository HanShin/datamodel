FROM openjdk:11-jdk

ARG JAR_FILE=build/libs/*.jar

# App folder
ENV APP_HOME /app

RUN mkdir $APP_HOME
COPY $JAR_FILE /app.jar
# Config
RUN mkdir $APP_HOME/config
VOLUME $APP_HOME/config

# logs
RUN mkdir $APP_HOME/log
VOLUME $APP_HOME/log

# Working Directory
WORKDIR $APP_HOME

# Port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]