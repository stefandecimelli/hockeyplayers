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