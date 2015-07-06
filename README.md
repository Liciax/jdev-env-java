Note: This will be working by the end of the week but is not functionning yet.

# A java development environment with eclipse as an IDE, in a few docker containers !

Eclipse, java, tomcat, mysql and maven in a few docker containers so that you can develop on any docker host.

## Requirements

* Docker 1.6.x
* Docker compose 1.3.x
* A VNC viewer on MacOS
* No process listening on port 8081 (or change it in the docker-compose.yml/docker-compose-otheros.yml)
* On MacOS, no process listening on port 5900 (or change it in the same way).

## Quickstart on Linux

Deploy a complete java developer stack with a single command:
```sh
docker-compose up
```
(Some images are quite heavy to download.)

A complete stack is then deployed, with a few binaries containers:
* tomcat
* java
* maven.

These containers are simply present so that you can change the version of each of these programs (cf Customisation). Two data containers also allow your data to be persistent:
* mysqldata
* eclipsedata.

Finally, mysql and eclipse are also provided in two distinct (linked) containers:
* mysql
* and eclipselinux.

As you will see, a simple application using a mysql database is already deployed. You can access it at:
http://localhost:8081/pizzaiolo2/pizzas

## Quickstart on MacOS

In order to deploy the same stack (except that eclipselinux is replaced by the eclipseotheros container) on any other OS than Linux, one can run:
```sh
docker-compose -f docker-compose-otheros.yml up
```

Because the X11 socket can't be shared as on linux, an X server, a windox manager (to dela with resizement problems), and a VNC server are also embarqued in the eclipse container. In order to view the x session, launch your VNC viewer on localhost:5900.
```sh
vncviewer localhost:5900
```

## Deploying your own applications

You can deploy a Maven project by simply adding it to the directory eclipsedata/workspace. Indeed you will find pizzaiolo2 there. Then within eclipse, import your existing Maven project: it is located in /home/javadev/workspace. Add it to your servlet, restart it, and you are done.

If your application uses a mysql database, which needs to be precreated, edit the docker-compose(-otheros).yml file. Replace the environment variables:
```sh
    - MYSQL_ROOT_PASSWORD=changeme
    - MYSQL_DATABASE=pizzaiolo2
```
so that they fit your needs. (Here a database is created and the root password is set.) An exhaustive list of environment variables is available in the docs of the mysql official image.


## Data persistence

Except for the eclipsedata and mysqldata containers, every container can be removed and recreated at any time, without you loosing data. This feature allows you to stop the stack, customize your containers (change the java version for example), restart the stack and retrieve your data.


## Customization

If you want to change the tomcat version, simply download the binaries you want, compress them to an archive called tomcat-bin.tar. Move this archive to the tomcat directory and replace the image instruction in your yml file.
```sh
tomcat:
  image: cwahl/javadevenv_tomcat
```
should become
```
tomcat
  build: tomcat
```

The same process can be applied for the maven, java and eclipse binaries (which have to be named apache-maven.tar, java-bin.tar and eclipse-bin.tar).

If you want to change the mysql version, have a look at the official image documentation and chage the tag in the docker-compose(-otheros).yml.
```sh
  image: mysql:5.7
```
