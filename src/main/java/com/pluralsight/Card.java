package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        // only return the suit if the card is face up
        if (isFaceUp) {
            return suit;
        } else {
            return "X";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "X";
        }
    }

    public int getPointValue() {
        int points = 0;
        // only return the value if the card is face up
        if (isFaceUp) {

            if (value.equals("A")) {
                points = 11;
            } else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
                points = 10;
            } else {
                points = Integer.parseInt(value);
            }

        } else {
            System.out.println("Face down");
        }

        return points;

    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}
