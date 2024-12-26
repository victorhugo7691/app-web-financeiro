# Etapa 1: Build do Front-End (Angular)
FROM node:18 AS frontend-builder

WORKDIR /frontend

# Copiando o package.json e o package-lock.json para o container
COPY ./frontend/package.json ./frontend/package-lock.json ./
RUN npm install

# Copiando os arquivos restantes do frontend
COPY ./frontend/ ./
RUN npm run build

# Etapa 2: Build do Back-End (Spring Boot)
FROM maven:3.9.5-eclipse-temurin-17 AS backend-builder

WORKDIR /app

# Copiando o pom.xml e os arquivos de configuração do Maven
COPY ./backend/pom.xml ./
RUN mvn dependency:go-offline

# Copiando o código do back-end
COPY ./backend/src ./src
RUN mvn clean package -DskipTests

# Etapa Final: Servindo o Front-End com Nginx e o Back-End com Spring Boot
FROM openjdk:17-jdk-slim AS final

# Instalando o Nginx para servir o Front-End
RUN apt-get update && apt-get install -y nginx

# Copiando a configuração do Nginx
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

# Copiando o JAR gerado do backend
COPY --from=backend-builder /app/target/*.jar /app/app.jar

# Copiando os arquivos do frontend (agora gerados pelo build do Angular)
COPY --from=frontend-builder /frontend/dist/financeiro-app /usr/share/nginx/html

# Expondo as portas
EXPOSE 8081 80

# Script para iniciar ambos os processos (backend e Nginx)
COPY ./start.sh /start.sh
RUN chmod +x /start.sh

CMD ["/start.sh"]
