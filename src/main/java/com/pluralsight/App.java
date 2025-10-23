package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Let's play!");

        ArrayList<Hand> hands = getHands();

        Deck deck = new Deck();
        deck.shuffle();

        dealCards(hands, deck, 2);

        displayResults(hands);

        // ask for hit
        hit(hands, deck);

        defineWinner(hands);
    }

    private static void hit(ArrayList<Hand> hands, Deck deck) {
        for (Hand hand: hands) {
            System.out.println(hand.getName());
            String answer = input("Hit? Y-yes N-No");

            if (answer.equals("Y")) {
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                hand.deal(card);
            }
        }
    }

    private static void dealCards(ArrayList<Hand> hands, Deck deck, int cardAmount) {

        for (int i = 1; i <= cardAmount; i++) {
            for (Hand hand: hands){
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                hand.deal(card);
            }
        }
    }

    private static void displayResults(ArrayList<Hand> hands) {
        for (Hand hand: hands) {
            String name = hand.getName();
            int handValue = hand.getValue();
            String info = String.format("%s hand is worth %d",name, handValue);
            System.out.println(info);
        }
    }

    private static Hand defineWinner(ArrayList<Hand> hands) {
        Hand winningHand = null;
        int highestValue = 0;

        for (Hand hand: hands) {
            int handValue = hand.getValue();

            if (handValue <= 21 && handValue > highestValue) {
                highestValue = handValue;
                winningHand = hand;
            }
        }

        System.out.println("Winner is: " + winningHand.getName() + " with hand: " + winningHand.getValue());

        return winningHand;
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
