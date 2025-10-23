package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Let's play!");

        ArrayList<Hand> players = collectPlayers();

        Deck deck = new Deck();
        deck.shuffle();

        // deal 2 cards to each hand
        for (int i = 0; i < 2; i++) {
            for (Hand player: players){
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                player.deal(card);
            }
        }


        for (Hand player: players) {
            String name = player.getName();
            int handValue = player.getValue();
            String info = String.format("%s hand is worth %d",name, handValue);
            System.out.println(info);
        }

        Hand winner = null;
        int bestValue = 0;

        for (int i = 0; i < players.size(); i++) {
            int playerValue = players.get(i).getValue();

            // Only consider players with value <= 21
            if (playerValue <= 21 && playerValue > bestValue) {
                bestValue = playerValue;
                winner = players.get(i);
            }
        }

        System.out.println("Winner is: " + winner.getName() + " with hand: " + winner.getValue());
    }

    public static ArrayList<Hand> collectPlayers() {
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
