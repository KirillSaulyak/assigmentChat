FROM tomcat:9-jdk17
RUN mv $CATALINA_HOME/webapps.dist/manager $CATALINA_HOME/webapps/manager
ADD target/chat.war /usr/local/tomcat/webapps/chat.war
EXPOSE 8080
CMD ["catalina.sh", "run"]