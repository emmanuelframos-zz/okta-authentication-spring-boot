./gradlew -q build --daemon --build-cache --parallel --configure-on-demand -x test &&
docker stop $(docker ps -qa) || true &&
docker build -t "okta-spring-boot-authentication" . &&
docker run -p 8080:8080 "okta-spring-boot-authentication"