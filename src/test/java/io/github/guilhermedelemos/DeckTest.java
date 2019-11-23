package io.github.guilhermedelemos;

import io.github.guilhermedelemos.blackjack.Card;
import io.github.guilhermedelemos.blackjack.Deck;
import io.github.guilhermedelemos.blackjack.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class DeckTest {

    @Test void drawTest() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card);
    }

    @Test void cardsLeft() {
        Deck deck = new Deck();
        int amount = deck.cardsLeft();
        deck.draw();
        assertTrue(deck.cardsLeft() < amount);
    }

    @Test void cardsDiscarded() {
        Deck deck = new Deck();
        int amount = deck.cardsDiscarded();
        deck.draw();
        assertTrue(deck.cardsDiscarded() > amount);
    }

    @Test void deckShuffle() {
        int percentual = 70;
        Deck deck = new Deck();
        List<Card> cartas = new ArrayList<>(); //deck.getCards();
        for(int i=0; i < deck.getCards().size(); i++) {
            cartas.add(deck.getCards().get(i));
        }
        deck.shuffle();

        int contador = 0;
        for(int i = 0; i < deck.getCards().size(); i++) {
            if(deck.getCards().get(i) != cartas.get(i)) {
                contador++;
            }
        }

        assertTrue((contador * 100 / 52) >= percentual);
    }

    @Test public void shuffleTest() {
        List<Card> cards = this.createCards();
        Deck deck = new Deck();
        Deck spy = spy(deck);

        when(
            spy.createDeck()
        ).thenReturn(
            cards
        );
        List<Card> scrambled = deck.shuffle();

        assertFalse(
            scrambled.get(0).equals(cards.get(0))
        );
    }

    public List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.ACE, Suit.CLUBS, 1));
        cards.add(new Card(Card.KING, Suit.DIAMONDS, 10));
        return cards;
    }

}
