FROM ubuntu:14.04 

ADD tomcat-bin /tomcat
ADD helloworld.war /tomcat/webapps/
ADD java-bin /opt/java
ENV JAVA_HOME=/opt/java

EXPOSE 8080

CMD /tomcat/bin/startup.sh && tail -f /tomcat/logs/catalina.out

