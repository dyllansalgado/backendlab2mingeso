FROM openjdk:15.0.1-oracle

COPY docker-entrypoint.sh /

RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["bash", "docker-entrypoint.sh"]

EXPOSE 8000
