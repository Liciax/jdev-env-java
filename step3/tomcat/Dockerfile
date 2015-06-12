FROM ubuntu:14.04 

ADD tomcat-bin /tomcat
ADD helloworld.war /tomcat/webapps/

CMD /tomcat/bin/startup.sh && tail -f /tomcat/logs/catalina.out

