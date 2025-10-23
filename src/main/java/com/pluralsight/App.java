package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Let's play!");

        ArrayList<Hand> hands = getHands();

        Deck deck = new Deck();
        deck.shuffle();

        // deal 2 cards to each hand
        for (int i = 0; i < 2; i++) {
            for (Hand hand: hands){
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                hand.deal(card);
            }
        }


        for (Hand hand: hands) {
            String name = hand.getName();
            int handValue = hand.getValue();
            String info = String.format("%s hand is worth %d",name, handValue);
            System.out.println(info);
        }

        Hand winningHand = null;
        int bestValue = 0;
//
//        for (int i = 0; i < hands.size(); i++) {
//            int playerValue = hands.get(i).getValue();
//
//            // Only consider hands with value <= 21
//            if (playerValue <= 21 && playerValue > bestValue) {
//                bestValue = playerValue;
//                winningHand = hands.get(i);
//            }
//        }

        for (Hand hand: hands) {
            int handValue = hand.getValue();

            if (handValue <= 21 && handValue > bestValue) {
                bestValue = handValue;
                winningHand = hand;
            }
        }

        System.out.println("Winner is: " + winningHand.getName() + " with hand: " + winningHand.getValue());
    }

    public static ArrayList<Hand> getHands() {
        int numberOfPlayers = Integer.parseInt(input("Please enter number of players: "));
        ArrayList<Hand> hands = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            String player = String.format("Player%d", i);
            Hand hand = new Hand();
            hand.setName(player);
            hands.add(hand);
        }

        return hands;
    }

    public static String input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
}
