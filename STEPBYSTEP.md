# Step by step guide

You can build this architecture step by step, so as to better understand it. The solutions can be found in the `stepx` repositories.


## Step 1
(Refer to the [step1](https://github.com/cwahl-Treeptik/jdev-env-java/tree/master/step-by-step/step1) repository.)

We want to deploy a simple helloworld application. We need java to be installed and the tomcat servlet to run.

For the sake of simplicity, let us do it in a single container. It loads the binaries, copies the `helloworld.war` archive in the `tomcat-bin/webapps` repository and starts tomcat.

```
docker build -t step1 .
docker run -dP step1
```

## Step 2
(Refer to the [step2](https://github.com/cwahl-Treeptik/jdev-env-java/tree/master/step-by-step/step2) repository.)

The goal is the same as in step 1, except that we build 3 containers:
* the java binaries
* the tomcat binaries
* the processes

```
docker build -t step2java java
docker run --name javabin step2java
docker build -t step2tomcat tomcat
docker run --name tomcatbin step2tomcat
docker build -t step2process process
docker run -dP --volumes-from=javabin --volumes-from=tomcatbin step2process
```

## Step 3
(Refer to the [step3](https://github.com/cwahl-Treeptik/jdev-env-java/tree/master/step-by-step/step3) repository.)

Exactly the same as step 2, but we use `docker-compose` which saves us many commands.

```
docker-compose up -d
```

## Step 4
(Refer to the [step4](https://github.com/cwahl-Treeptik/jdev-env-java/tree/master/step-by-step/step4) repository.)

The eclipse IDE is added to our setup. It will be split into 2 containers:
* the eclipse data, containing the helloworld project
* the eclipse process, which also contains the java and tomcat processes

Depending on wether you use linux or not, use either the `docker-compose-linux.yml` or the `docker-compose-otheros.yml` file.

```
docker-compose -f docker-compose-linux.yml up -d
```

* Select `/home/javadev/workspace` as a workspace
* Add an Apache Tomcat v8.0 Server named localhost
* Its installation directory is `/tomcat-bin`
* The JRE is `java-bin`
* Select the server and import an existing Maven Project, with the root directory `/workspace/helloworld`
* Add the helloworld project to the server
* Restart the server
