package io.github.guilhermedelemos;

import io.github.guilhermedelemos.blackjack.Card;
import io.github.guilhermedelemos.blackjack.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {

    @Test void drawTest() {
        Deck deck = new Deck();
        int amount = deck.cardsLeft();
        Card card = deck.draw();
        assertNotNull(card);
        assertTrue(deck.cardsLeft() < amount);

    }



}
