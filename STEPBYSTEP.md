# Step by step guide

You can build this architecture step by step, so as to better understand it. The solutions can be found in the `stepx` repositories.


## Step 1
(This container is defined in the [step1] repository.)

We want to deploy a simple helloworld application. We need java to be installed and the tomcat servlet to run.

For the sake of simplicity, let us do it in a single container. It loads the binaries, copies the `helloworld.war` archive in the `tomcat-bin/webapps` repository and starts tomcat.
