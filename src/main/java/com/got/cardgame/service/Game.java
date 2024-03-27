package com.got.cardgame.service;

import com.got.cardgame.model.*;

import java.util.*;

public class Game {
    private HashMap<String, Player> players;
    private Map<String, List<Card>> playerCards;
    private Stack<Card> decks;
    private List<String> events;
    private String id;

    public Game(String id) {
        players = new HashMap<>();
        playerCards = new HashMap<String, List<Card>>();
        decks = new Stack<>();
        events = new ArrayList<>();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void shuffleDeck() {
        Collections.shuffle(decks);
        events.add("Deck was shuffled.");
    }

    public void addDeckToGame(Deck deck) {
        Stack<Card> deckCards = deck.getCards();
        while (!deckCards.empty()){
            decks.push(deckCards.pop());
        }
        events.add("Deck was added to game.");
    }

    synchronized public void addPlayerToGame(Player player) {
        players.put(player.getId(), player);
        playerCards.put(player.getId(), new ArrayList<>());
        events.add("Player " + player.getId() + " was added to game.");
    }

    synchronized public void removePlayerFromGame(String playerId) {
        players.remove(playerId);
        playerCards.remove(playerId);
        events.add("Player " + playerId + " was removed from the game.");
    }

    public void dealCards(String playerId) {
        if (!decks.empty()) {
            Card dealtCard = decks.pop();
            playerCards.get(playerId).add(dealtCard);
            events.add("Player " + playerId + " was dealt the " + dealtCard.getSuitValue() + " " + dealtCard.getFaceValue() + ".");
        }
    }

    public List<Card> getPlayerCards(String playerId) {
        events.add(playerId + " players cards was requested.");

        return playerCards.get(playerId);
    }

    public int getPlayerScore(String playerId) {
        int score = 0;

        for (Card card : playerCards.get(playerId)) {
            score = score + card.getNumberValue();
        }
        events.add(playerId + " players score was requested.");

        return score;
    }

    public List<PlayerScore> getAllPlayerScores() {
        List<PlayerScore> playerScores = new ArrayList<>();

        for (Map.Entry<String, Player> playerEntry : players.entrySet()) {
            playerScores.add(new PlayerScore(playerEntry.getValue(), getPlayerScore(playerEntry.getKey())));
        }

        playerScores.sort((PlayerScore score1, PlayerScore score2) -> Integer.compare(score2.score, score1.score));
        events.add("All players score was requested.");

        return playerScores;
    }

    public HashMap<Card.Suit, Integer> getRemainingSuitCount() {
        HashMap<Card.Suit, Integer> suitCount = new HashMap<>();

        for (Card.Suit suit : Card.Suit.class.getEnumConstants()) {
            suitCount.put(suit, 0);
        }

        for (Card remainingCard : decks) {
            Card.Suit remainingCardSuit = remainingCard.getSuit();
            suitCount.put(remainingCardSuit, suitCount.get(remainingCardSuit) + 1);
        }
        events.add("Remaining suit count details was requested.");

        return suitCount;
    }
    
    public List<String> getGameEvents() {
        return events;
    }

}
