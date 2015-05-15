FROM busybox

RUN apt-get update

ADD tomcat tomcat

EXPOSE 8080 22

CMD ["tomcat/bin/startup.sh" & tail -f tomcat/logs/catalina.out]

