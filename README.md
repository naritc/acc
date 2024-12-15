# migrate db
mvn -DenvFilePath=/env/local.env -Dflyway.configFiles=flyway.conf flyway:migrate