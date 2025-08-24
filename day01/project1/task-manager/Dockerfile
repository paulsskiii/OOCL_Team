FROM node:18-alpine AS frontend-build
WORKDIR /app/frontend
COPY task-manager-frontend/package*.json ./
RUN npm ci
COPY task-manager-frontend/ ./
RUN npm run build

FROM eclipse-temurin:17-jdk-jammy AS backend-build
WORKDIR /app/backend
COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:resolve
COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=backend-build /app/backend/target/*.jar app.jar
COPY --from=frontend-build /app/frontend/build ./static
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]