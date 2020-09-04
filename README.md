# demo

mvn spring-boot:run -Dspring-boot.run.profiles=local

### jenkins
http://<host:port>/github-webook/

### docker mysql
docker run -p 3306:3306 --name=mysql57 -e MYSQL_ROOT_PASSWORD=pwd -d mysql:latest


### ssh aws

ssh -i {path to pem} ec2-user@{Public IPv4 DNS}
