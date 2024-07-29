./mvnw clean package -DskipTests
docker build -t cliente-persona:latest ./cliente-persona
docker build -t cuenta-movimientos:latest ./cuenta-movimientos
