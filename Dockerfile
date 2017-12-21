FROM java:8-jdk

ENV HOME=/home/application

WORKDIR $HOME/okta-spring-boot-authentication

ADD build/libs/okta-spring-boot-authentication.jar okta-spring-boot-authentication.jar

CMD ["java", "-jar", "okta-spring-boot-authentication.jar"]