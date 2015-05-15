Commandes nécessaire pour lancer le container eclipse : 

docker run -ti --rm \
       -e DISPLAY=$DISPLAY \
       -v /tmp/.X11-unix:/tmp/.X11-unix \
       eclipse

+ instructions pour docker-compose.yml

- ajout JAVA_HOME=/opt/java pour container eclipse
- volume entre /opt/java du container eclipse et container java
- récupérer container officiel mysql
- link entre tomcat et mysql
- volume entre tomcat et workspace java
- externalisation workspace dans un container busybox
- expose/forward 8080 du tomcat pour accéder à l'appli


+ ajout registry officiel + toutes les images buildées à l'intérieur
