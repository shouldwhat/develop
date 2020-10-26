# Use maven to compile the java application.
FROM docker.io/maven AS build-env

# Set the working directory to /app
WORKDIR /app

# copy the pom.xml file to download dependencies
COPY pom.xml ./

# download dependencies as specified in pom.xml
# building dependency layer early will speed up compile time when pom is unchanged
RUN mvn verify --fail-never

# Copy the rest of the working directory contents into the container
COPY . ./

# Compile the application.
RUN mvn -Dmaven.test.skip=true package -U

# Build runtime image.
FROM openjdk:8-jdk-alpine

# Copy the compiled files over.
COPY --from=build-env /app/target/ /app/

EXPOSE 8080

ENTRYPOINT "bin/ash" -c "java $JAVA_OPTS  -jar /app/kafka-producer-consumer-example.jar"