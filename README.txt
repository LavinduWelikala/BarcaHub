
docker run -d -p 9000:9000 --name sonarqube sonarqube:latest

Once the container is running, you can access SonarQube at http://localhost:9000. The default admin credentials are:

Username: admin
Password: admin

Log into your SonarQube instance and navigate to My Account > Security.
Generate a new token by clicking Generate Tokens and copying it. Then replace the token as below.

mvn clean test verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_2666cd3eb53e91ed005f53d456e61810b260e095


mvn test -Dtest=TestClassName#TestMethodName

