# Hockey Players

REST API for CRUD operations with hockey players and teams.
I made this project so I can learn Spring, and specifically Spring Web and Spring Data JPA.
This repo does not return database entities, and instead requires DTO objects for JSON payload and responses. I use Java records for these DTO objects.

### Example
Create the teams:
```
curl --request POST \
  --url http://localhost:8080/team \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Toronto Maple Leafs"
}'
curl --request POST \
  --url http://localhost:8080/team \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Edmonton Oilers"
}'
```
Then create the players:
```
curl --request POST \
  --url http://localhost:8080/player \
  --header 'Content-Type: application/json' \
  --data '{
  "firstname": "Auston",
  "lastname": "Matthews",
  "jerseyNumber": 34,
  "team": {
    "name": "Toronto Maple Leafs"
  }
}'
curl --request POST \
  --url http://localhost:8080/player \
  --header 'Content-Type: application/json' \
  --data '{
  "firstname": "William",
  "lastname": "Nylander",
  "jerseyNumber": 88,
  "team": {
    "name": "Toronto Maple Leafs"
  }
}'
curl --request POST \
  --url http://localhost:8080/player \
  --header 'Content-Type: application/json' \
  --data '{
  "firstname": "Connor",
  "lastname": "McDavid",
  "jerseyNumber": 97,
  "team": {
    "name": "Edmonton Oilers"
  }
}'
```
Finally, query the players and teams:
```
curl --request GET \
  --url http://localhost:8080/players
curl --request GET \
  --url http://localhost:8080/teams
```

### To create and run a production image:
Start the database:
Create a network:
```
docker network create hockeyplayer-network
```
```
docker run --rm --name hockeyplayer-database --network hockeyplayer-network --hostname hockeyplayer-database -e POSTGRES_PASSWORD=password -e POSTGRES_DB=hockey -d postgres DATABASE mydatabase;
```
Create the docker image
```
mvn -Dmaven.test.skip=true spring-boot:build-image -P production
```
And run it
```
docker run --rm -p 8080:8080 --network hockeyplayer-network \
  -e SPRING_PROFILES_ACTIVE=production \
  -e DATABASE_HOST=hockeyplayer-database \
  -e DATABASE_PORT=5432 \
  -e DATABASE_NAME=hockey \
  -e DATABASE_USERNAME=postgres \
  -e DATABASE_PASSWORD=password \
docker.io/library/hockeyplayers:0.0.1-SNAPSHOT 
```
All of the localhost:8080 curl commands above should work.