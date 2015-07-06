FROM buildpack-deps:jessie-curl

RUN mkdir /java-bin
RUN curl -L -C - -b "oraclelicense=accept-securebackup-cookie" -O http://download.oracle.com/otn-pub/java/jdk/8u45-b14/jdk-8u45-linux-x64.tar.gz \
	&& tar -xvf jdk-8u45-linux-x64.tar.gz -C java-bin \
	&& rm jdk-8u45-linux-x64.tar.gz*
