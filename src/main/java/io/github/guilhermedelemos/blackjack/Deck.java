package io.github.guilhermedelemos.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;
    private int originalSize;

    public Deck() {
        this.cards = this.createDeck();
        this.originalSize = this.cards.size();
    }

    public List<Card> createDeck() {
        List<Card> cards = new ArrayList<>();

        for(int i=0; i<Suit.values().length; i++) {
            cards.add(
                new Card(Card.ACE, Suit.values()[i], 1)
            );

            for(int j=2; j<= 10; j++) {
                cards.add(
                    new Card(Integer.toString(j), Suit.values()[i], j)
                );
            }
            cards.add(
                new Card(Card.JACK, Suit.values()[i], 10)
            );
            cards.add(
                new Card(Card.QUEEN, Suit.values()[i], 10)
            );
            cards.add(
                new Card(Card.KING, Suit.values()[i], 10)
            );
        }
        return cards;
    }

    public List<Card> shuffle() {
        Collections.shuffle(this.cards);
        return this.cards;
    }

    public void shuffle(List<Card> cards) {
        this.cards.addAll(cards);
        this.shuffle();
    }

    public Card draw() {
        return this.cards.size() > 0 ? this.cards.remove(0) : null;
    }

    public int cardsLeft() {
        return this.cards.size();
    }

    public int cardsDiscarded() {
        return this.originalSize - this.cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
