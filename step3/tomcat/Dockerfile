FROM ubuntu:14.04 

ADD tomcat-bin.tar /
ADD helloworld.war /tomcat-bin/webapps/

CMD /tomcat-bin/bin/startup.sh && tail -f /tomcat-bin/logs/catalina.out

