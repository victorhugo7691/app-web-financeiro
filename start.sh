#!/bin/bash

# Iniciar o Spring Boot em segundo plano
java -jar /app/app.jar &

# Iniciar o Nginx
nginx -g 'daemon off;'
