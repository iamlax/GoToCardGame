package com.got.cardgame.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Games {
    private HashMap<String, Game> games;

    public Games() {
        games = new HashMap<>();
    }

    synchronized public void addGame(Game game) {
        games.put(game.getId(), game);
    }

    synchronized public void removeGame(String gameId){
        games.remove(gameId);
    }
    public HashMap<String, Game> getGames() {
        return games;
    }
}
