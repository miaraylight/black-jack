package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Let's play!");

        Deck deck = new Deck();

        Hand hand1 = new Hand();

        for (int i = 0; i < 5; i++){
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            hand1.deal(card);
        }
        int handValue = hand1.getValue();
        System.out.println("This hand is worth " + handValue);
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
