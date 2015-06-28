FROM ubuntu:14.04 

ENV JAVA_HOME=/opt/java-bin

EXPOSE 8080

CMD ls / && /tomcat-bin/bin/startup.sh && tail -f /tomcat-bin/logs/catalina.out
