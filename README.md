# Car Parts demo

## Tech stack
- Java 11
- Spring Boot 2.7.0
- Apache Cassandra
- Mapstruct

### How to run
#### Prerequisites:
- [JRE 11](https://www.oracle.com/cis/java/technologies/javase/jdk11-archive-downloads.html)
- [Docker](https://docs.docker.com/desktop/#download-and-install)

#### Steps:
##### Set up Cassandra Docker container
NB: tested in Windows PowerShell
1. `cd` to the repository root
2. `docker-compose up -d`
3. Run `docker ps` and copy the id of the new **cassandra:4.0** container
4. `docker exec -it <cassandra_container_id> /bin/bash`
5. `cqlsh -u cassandra -p cassandra`
6. `CREATE KEYSPACE parts_test WITH REPLICATION={'class':'SimpleStrategy', 'replication_factor':1};`

##### Run the application
1. Open another terminal instance and `cd` to the repository root
2. `./mvnw clean package`
3. `java -jar target/carrtsdemo-0.0.1-SNAPSHOT.jar`

##### Test
Import **_carpartsdemo.postman_collection.json_** collection into Postman and experiment.

##### Shutdown
`docker-compose down -v`