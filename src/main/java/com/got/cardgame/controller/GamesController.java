package com.got.cardgame.controller;

import com.got.cardgame.model.*;
import com.got.cardgame.service.Game;
import com.got.cardgame.service.Games;
 import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="api/v1/games")
public class GamesController {

    Games games;
    public GamesController(Games games) {
        this.games = games;
    }

    @GetMapping()
    public Object getGames() {
        return games.getGames();
    }

    @PostMapping("/{gameId}")
    public void createGame(@PathVariable("gameId") String gameId) {
        Game game = new Game(gameId);
        games.addGame(game);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable("gameId") String gameId) {
        games.removeGame(gameId);
    }

    @PostMapping("/{gameId}/decks")
    public void addDeckToGame(@PathVariable("gameId") String gameId) {
        Deck deck = new Deck();
        deck.createDeck();

        games.getGames().get(gameId).addDeckToGame(deck);
    }

    @PostMapping("/{gameId}/players/{playerId}")
    public void addPlayerToGame(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {
        Player player = new Player(playerId);
        games.getGames().get(gameId).addPlayerToGame(player);
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    public void removePlayerFromGame(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {
        games.getGames().get(gameId).removePlayerFromGame(playerId);
    }

    @PostMapping("/{gameId}/decks/{playerId}")
    public void dealCardToPlayer(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {
        games.getGames().get(gameId).dealCards(playerId);
    }

    @GetMapping("/{gameId}/decks/{playerId}")
    public List<Card> getPlayerCards(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {
        return games.getGames().get(gameId).getPlayerCards(playerId);
    }

    @GetMapping("/{gameId}/players")
    public List<PlayerScore> getScore(@PathVariable("gameId") String gameId) {
        return games.getGames().get(gameId).getAllPlayerScores();
    }

    @GetMapping("/{gameId}/suits")
    public HashMap<Card.Suit, Integer> getRemainingSuits(@PathVariable("gameId") String gameId) {
        return games.getGames().get(gameId).getRemainingSuitCount();
    }

    @GetMapping("/{gameId}/events")
    public List<String> getGameEvents(@PathVariable("gameId") String gameId) {
        return games.getGames().get(gameId).getGameEvents();
    }
}
