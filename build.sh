app=consummerapp
tag=2.9
mvn clean package -DskipTests
docker build -t ${app}:${tag} .