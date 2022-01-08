FROM openjdk:17.0.1-oracle

RUN chmod +x ./gradlew

RUN ./gradlew build -x test

COPY docker-entrypoint.sh /

RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["bash","docker-entrypoint.sh"]

EXPOSE 3000