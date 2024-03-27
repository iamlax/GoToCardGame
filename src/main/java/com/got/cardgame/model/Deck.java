package com.got.cardgame.model;


import java.util.Collections;
import java.util.Stack;

public class Deck {

    public Stack<Card> cards = new Stack<>();

    public void createDeck() {
        Card.Suit[] suitValues = Card.Suit.class.getEnumConstants();
        Card.Face[] faceValues = Card.Face.class.getEnumConstants();

        for(int suitIndex = 0; suitIndex < suitValues.length; ++suitIndex) {
            for(int faceIndex = 0; faceIndex < faceValues.length; ++faceIndex) {
                Card tmpCard = new Card(suitValues[suitIndex], faceValues[faceIndex]);
                cards.push(tmpCard);
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
