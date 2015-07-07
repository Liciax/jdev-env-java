FROM buildpack-deps:jessie-curl

RUN mkdir -p /eclipse-bin
RUN apt-get update && apt-get install -y libgtk2.0-0 libcanberra-gtk-module libxext-dev libxrender-dev libxtst-dev \
	&& curl -fSL http://www.eclipse.org/downloads/download.php\?file\=/technology/epp/downloads/release/luna/R/eclipse-jee-luna-R-linux-gtk-x86_64.tar.gz\&mirror_id\=580 -o eclipse.tar.gz \
	&& tar -xvf eclipse.tar.gz -C /eclipse-bin

RUN export uid=1000 gid=1000 && \
    mkdir -p /home/javadev && \
    echo "javadev:x:${uid}:${gid}:JavaDev,,,:/home/javadev:/bin/bash" >> /etc/passwd && \
    echo "javadev:x:${uid}:" >> /etc/group && \
    echo "javadev ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/javadev && \
    chmod 0440 /etc/sudoers.d/javadev && \
    chown ${uid}:${gid} -R /home/javadev

USER javadev
WORKDIR /home/javadev

ENV JAVA_HOME /opt/java-bin
ENV PATH $PATH:$JAVA_HOME/bin

CMD /eclipse-bin/eclipse
