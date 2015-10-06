# Step by step guide

You can build this architecture step by step, so as to better understand it. The solutions can be found in the `stepx` repositories.


## Step 1
(Refer to the [step1] repository.)

We want to deploy a simple helloworld application. We need java to be installed and the tomcat servlet to run.

For the sake of simplicity, let us do it in a single container. It loads the binaries, copies the `helloworld.war` archive in the `tomcat-bin/webapps` repository and starts tomcat.

```
docker build -t step1 .
docker run -dP step1
```

## Step 2
(Refer to the [step2] repository.)

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
(Refer to the [step2] repository.)

Exactly the same as step 2, but we use `docker-compose` which saves us many commands.

```
docker-compose up -d
```
