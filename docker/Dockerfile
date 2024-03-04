FROM eclipse-temurin:21-alpine

COPY blazegraph.jar /root/blazegraph.jar
COPY --chmod=600 etc/keystore /root/etc/keystore

EXPOSE 9999

CMD ["java", "-server", "-Xmx4g", "-jar", "/root/blazegraph.jar"]

# EOF ##########################################################################
