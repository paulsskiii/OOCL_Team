FROM node:18 AS frontend-build
WORKDIR /app/frontend
COPY task-manager-frontend/package*.json ./
RUN npm ci --include=dev
COPY task-manager-frontend/ ./
RUN chmod +x node_modules/.bin/react-scripts
RUN npm run build
FROM openjdk:17-jdk-slim AS backend-build
WORKDIR /app/backend
COPY task-manager/pom.xml ./
COPY task-manager/.mvn .mvn
COPY task-manager/mvnw ./
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve
COPY task-manager/src ./src
RUN ./mvnw clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=backend-build /app/backend/target/*.jar app.jar
COPY --from=frontend-build /app/frontend/build ./static
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
