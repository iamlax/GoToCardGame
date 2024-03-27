# GoToCardGame

## To run the project
```http
./mvnw spring-boot:run
```
## Create game
```http
POST http://localhost:8080/api/v1/games/{gameId}
```

## Delete game
```http
DELETE http://localhost:8080/api/v1/games/{gameId}
```

## Add deck to game deck
```http
POST http://localhost:8080/api/v1/games/{gameId}/decks
```

## Add player to game
```http
POST http://localhost:8080/api/v1/games/{gameId}/players/{playerId}
```

## Remove player from game
```http
DELETE http://localhost:8080/api/v1/games/{gameId}/players/{playerId}
```

## Deal card to player
```http
POST http://localhost:8080/api/v1/games/{gameId}/decks/{playerId}
```

## Get player cards
```http
GET http://localhost:8080/api/v1/games/{gameId}/decks/{playerId}
```

## Get players in game and score
```http
GET http://localhost:8080/api/v1/games/{gameId}/players
```

## Get remaining suits in game
```http
GET http://localhost:8080/api/v1/games/{gameId}/suits
```

## Get events that happened in a game
```http
GET http://localhost:8080/api/v1/games/{gameId}/events
```