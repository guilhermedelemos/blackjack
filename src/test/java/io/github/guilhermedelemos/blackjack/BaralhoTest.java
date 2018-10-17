package io.github.guilhermedelemos.blackjack;

import org.junit.Test;
import static org.junit.Assert.*;

public class BaralhoTest {
    
    @Test
    public void puxarTest() {
        Baralho baralho = new Baralho();
        Carta carta = baralho.puxar();
        assertNotNull(carta);
        assertEquals(52, baralho.getBaralho().size());
    }
    
}
