From tomcat:8-jre8
VOLUME /tmp
ARG war
ARG name
RUN echo "${war}"
RUN echo "${name}"
COPY target/${war} /usr/local/tomcat/webapps/
RUN mv /usr/local/tomcat/webapps/${war} /usr/local/tomcat/webapps/${name}


