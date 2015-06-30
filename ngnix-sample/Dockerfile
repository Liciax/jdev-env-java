FROM ubuntu:14.04

RUN apt-get update && \
apt-get install -y nginx

ADD index.html /usr/share/nginx/html/
VOLUME /var/cache/nginx

EXPOSE 88
CMD ["nginx", "-g", "daemon off;"]

