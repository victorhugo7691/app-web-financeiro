# Etapa 1: Build do Front-End (Angular)
FROM node:18 AS frontend-builder

# Definindo o diretório de trabalho para o front-end
WORKDIR /frontend

# Copiando o package.json e o package-lock.json para o container
COPY frontend/package.json frontend/package-lock.json ./
RUN npm install

# Copiando o restante dos arquivos do front-end
COPY frontend/ ./

# Rodando o build do Angular para gerar a pasta dist
RUN npm run build

# Etapa 2: Build do Back-End (Spring Boot)
FROM maven:3.9.5-eclipse-temurin-17 AS backend-builder

# Definindo o diretório de trabalho para o back-end
WORKDIR /app

# Copiando o pom.xml e os arquivos de configuração do Maven
COPY backend/pom.xml .

# Baixando as dependências para cache
RUN mvn dependency:go-offline

# Copiando o restante do código do back-end
COPY backend/src ./src

# Build do JAR do back-end (Spring Boot)
RUN mvn clean package -DskipTests

# Etapa Final: Servindo o Front-End com Nginx e o Back-End com Spring Boot
FROM openjdk:17-jdk-slim AS final

# Instalando o Nginx para servir o Front-End
RUN apt-get update && apt-get install -y nginx

# Copiando o arquivo de configuração do Nginx
COPY nginx/default.conf /etc/nginx/conf.d/default.conf

# Copiando o JAR gerado do back-end
COPY --from=backend-builder /app/target/*.jar /app/app.jar

# Copiando os arquivos do front-end (agora gerados pelo build do Angular)
COPY --from=frontend-builder /frontend/dist/[nome-do-projeto-angular] /usr/share/nginx/html

# Expondo a porta 8081 (para o Spring Boot) e 80 (para o Nginx)
EXPOSE 8081 80

# Comando para rodar o back-end e o Nginx
CMD ["sh", "-c", "java -jar /app/app.jar & nginx -g 'daemon off;'"]
