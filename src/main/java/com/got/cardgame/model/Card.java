package com.got.cardgame.model;

import java.util.Map;

import static java.util.Map.entry;

public class Card {

    public enum Suit {
        HEARTS("Hearts"),
        SPADES("Spades"),
        CLUBS("Clubs"),
        DIAMONDS("Diamonds");

        private final String suitValue;

        Suit(String suitValue) {
            this.suitValue = suitValue;
        }

        public String getSuitValue() {
            return suitValue;
        }

        @Override
        public String toString() {
            return this.getSuitValue();
        }
    }

    public enum Face {
        ACE("Ace"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("Jack"),
        QUEEN("Queen"),
        KING("King");

        private final String faceValue;

        Face(String faceValue) {
            this.faceValue = faceValue;
        }

        public String getFaceValue() {
            return faceValue;
        }

        @Override
        public String toString() {
            return this.getFaceValue();
        }
    }

    private final Suit suit;
    private final Face face;
    private final Map<Face, Integer> cardValue = Map.ofEntries(
            entry(Face.ACE, 1),
            entry(Face.TWO, 2),
            entry(Face.THREE, 3),
            entry(Face.FOUR, 4),
            entry(Face.FIVE, 5),
            entry(Face.SIX, 6),
            entry(Face.SEVEN, 7),
            entry(Face.EIGHT, 8),
            entry(Face.NINE, 9),
            entry(Face.TEN, 10),
            entry(Face.JACK, 11),
            entry(Face.QUEEN, 12),
            entry(Face.KING, 13)
    );

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Face getFace() {
        return this.face;
    }

    public String getSuitValue() {
        return suit.getSuitValue();
    }

    public String getFaceValue() {
        return face.getFaceValue();
    }

    public int getNumberValue() {
        return cardValue.get(this.face);
    }
}