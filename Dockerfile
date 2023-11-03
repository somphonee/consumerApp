
FROM openjdk:17-alpine
ENV LOCAL_APP_FILE consummerapp-0.0.1-SNAPSHOT.jar
ENV APP_DIR /home/app
ENV IMAGE_APP_FILE consummerapp.jar

EXPOSE 8082

WORKDIR ${APP_DIR}
COPY target/$LOCAL_APP_FILE $APP_DIR/$IMAGE_APP_FILE
ENTRYPOINT exec java -jar ${APP_DIR}/$IMAGE_APP_FILE --spring.config.location=$CONFIG_FILE






#FROM  openjdk:17.0.2-jdk
#
#ARG LOCAL_APP_FILE=consummerapp-0.0.1-SNAPSHOT.jar
#
#RUN mkdir /home/app
#
#COPY target/${LOCAL_APP_FILE} /home/app/consummerapp.jar
#
#WORKDIR /home/app
#
#EXPOSE 8082
#
#ENTRYPOINT exec java -jar /home/app/consummerapp.jar --spring.config.location=/home/app/config/application.yaml
#
