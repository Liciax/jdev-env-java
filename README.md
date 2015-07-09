# A java development environment with eclipse as an IDE, in a few docker containers !

Eclipse, java, tomcat, mysql and maven in a few docker containers so that you can develop on any docker host.

## Requirements

* Docker 1.6.x
* Docker compose 1.3.x
* A VNC viewer on MacOS

## Quickstart on Linux

Deploy a complete java developer stack with a single command:
```sh
docker-compose up
```
(Some images are quite heavy to download.)

A complete stack is then deployed, with a few binaries containers:
* [tomcat](http://tomcat.apache.org/) (8)
* [java](https://www.oracle.com/java/index.html) (oracle jdk 8)
* [maven](https://maven.apache.org/) (3.3.3)

These containers are simply present so that you can change the version of each of these programs (cf Customisation). Two data containers also allow your data to be persistent:
* mysqldata
* eclipsedata.

Finally, mysql and eclipse are also provided in two distinct (linked) containers:
* [mysql](https://www.mysql.fr/) (5.7)
* and [eclipse](https://eclipse.org/downloads/) (luna JEE).

![alt tag](https://github.com/cwahl-Treeptik/jdev-env-java/blob/master/javadev.png)

As you will see, a simple application using a mysql database is already [deployed](http://localhost:8081/pizzaiolo2/pizzas). You can access it at:
http://localhost:8081/pizzaiolo2/pizzas

## Quickstart on MacOS

In order to deploy the same stack (except that eclipselinux is replaced by the eclipseotheros container) on any other OS than Linux, one can run:
```sh
docker-compose -f docker-compose-otheros.yml up
```

Because the X11 socket can't be shared as on linux, an X server, a window manager (to deal with resizement issues), and a VNC server are also embarqued in the eclipse container. In order to view the X session, launch your [VNC client](http://sourceforge.net/projects/cotvnc/) on `localhost:5900`. On Linux for example, with vncviewer:
```sh
vncviewer localhost:5900
```

## Deploying your own applications

You can deploy a Maven project by simply adding it to the directory `eclipsedata/workspace`. Indeed you will find `pizzaiolo2` there. Then within eclipse, import your existing Maven project: it is located in `/home/javadev/workspace`. Add it to your servlet, restart it, and you are done.

If your application uses a mysql database, edit the `docker-compose(-otheros).yml` file, and replace the environment variables for the mysql container. An exhaustive list of environment variables is available in the docs of the [mysql official image](https://registry.hub.docker.com/_/mysql/).


## Data persistence

Except for the eclipsedata and mysqldata containers, every container can be removed and recreated at any time, without you loosing data. This feature allows you to stop the stack, customize your containers (change the java version for example), restart the stack and retrieve your data.


## Customization

In order to customize the containers, you should rather use the `docker-compose(-otheros)-build.yml` file. Run
```sh
docker-compose -f docker-compose(-otheros)-build.yml up
```
to start the stack.

The tomcat, java, maven and eclipse Dockerfiles can be edited, so that you replace the downloaded binaries with the ones you are interested in.

If you want to change the mysql version, have a look at the [official image documentation](https://registry.hub.docker.com/_/mysql/) and change the tag in the docker-compose(-otheros).yml.
