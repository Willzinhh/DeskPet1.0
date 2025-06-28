
# =================================================================
# ESTÁGIO 1: Build da Aplicação com Maven
# =================================================================
FROM maven:3.9-eclipse-temurin-21 AS build

# Diretório de trabalho no container
WORKDIR /app

# Clona o repositório do GitHub
RUN git clone https://github.com/Willzinhh/DeskPet1.0.git .

# Compila o projeto e gera o .war
RUN mvn clean package -DskipTests

# =================================================================
# ESTÁGIO 2: Ambiente de Execução com WildFly
# =================================================================
FROM quay.io/wildfly/wildfly:35.0.1.Final-jdk17

# Copia o arquivo .war gerado no estágio anterior para o WildFly
COPY --from=build /app/target/DeskPet1.0.war /opt/jboss/wildfly/standalone/deployments/
