# Usando a imagem base do OpenJDK 17 slim
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o JAR da aplicação para o diretório de trabalho
COPY target/*.jar app.jar

# Definindo variável de ambiente para a URL
ENV DBURL=jdbc:postgresql://dpg-cthpdj3qf0us73dmjkfg-a.oregon-postgres.render.com:5432/db_financeiro
ENV DBUSER=app_financeiro
ENV DBPASSWORD=2vFqDEWPB8MNFz7QPCQ4GZlcpZb40PLb

# Expondo a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]