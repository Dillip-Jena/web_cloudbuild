# Base image: Tomcat 10 + JDK 21
FROM tomcat:10.1-jdk21-openjdk-slim

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR as ROOT.war
COPY target/web_cloudbuild.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]