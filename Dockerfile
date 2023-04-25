# syntax=docker/dockerfile:1
FROM gradle:alpine as build
WORKDIR /app

COPY settings.gradle .
COPY build.gradle .
COPY lombok.config .
COPY src src
RUN gradle bootJar -x test


FROM eclipse-temurin:17-jdk-alpine AS layers
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../../../app.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG DEPENDENCY=/app/build/libs/dependency
COPY --from=layers ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=layers ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=layers ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","b.illia.healthportal.server.HealthPortalServerApplication"]
