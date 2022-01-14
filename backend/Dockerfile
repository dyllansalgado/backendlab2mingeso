FROM openjdk:11-oracle

COPY docker-entrypoint.sh /

RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["bash", "docker-entrypoint.sh"]
// COPY backend-0.0.1-SNAPSHOT.jar / backend-0.0.1-SNAPSHOT.jar
EXPOSE 8000
