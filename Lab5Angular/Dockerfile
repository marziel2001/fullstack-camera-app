FROM nginx:1.23.3

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="latest"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/lab5-angular /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
