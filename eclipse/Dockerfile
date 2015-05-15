FROM ubuntu:14.04

RUN apt-get update

RUN export uid=1000 gid=1000 && \
    mkdir -p /home/javadev && \
    echo "javadev:x:${uid}:${gid}:JavaDev,,,:/home/javadev:/bin/bash" >> /etc/passwd && \
    echo "javadev:x:${uid}:" >> /etc/group && \
    echo "javadev ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/javadev && \
    chmod 0440 /etc/sudoers.d/javadev && \
    chown ${uid}:${gid} -R /home/javadev

ADD eclipse eclipse

USER javadev

ENV HOME /home/javadev

CMD eclipse/eclipse
