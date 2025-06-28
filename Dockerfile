
# Etapa 1 - Build da aplicação
# Utiliza uma imagem oficial do Maven
FROM maven:3.9-eclipse-temurin-21 AS build

# Diretório de trabalho no container
# /app onde tudo será feito (clone, build, etc).
WORKDIR /app

# Clona o repositório do GitHub
# . ao final indica que os arquivos do repositório serão colocados em /app
RUN git clone https://github.com/Willzinhh/DeskPet1.0.git .

# Compila o projeto e gera o .war (já q em cada maquina o War pode ser gerado diferente
# entao sempre é preciso gerar um novo war ao inicializar o conteiner)
RUN mvn clean package -DskipTests


# ESTÁGIO 2 - Ambiente de Execução com WildFly
# utilizado para deploy de aplicações .war
FROM quay.io/wildfly/wildfly:35.0.1.Final-jdk17

# Copia o arquivo .war gerado no estágio anterior para o WildFly
COPY --from=build /app/target/DeskPet1.0.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080

VOLUME ["/opt/jboss/wildfly/standalone/log"]