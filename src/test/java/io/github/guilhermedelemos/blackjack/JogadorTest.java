package io.github.guilhermedelemos.blackjack;

import org.junit.Test;
import static org.junit.Assert.*;

public class JogadorTest {
    
    public JogadorTest() {
    }
    
    @Test
    public void pontuacaoTest() {
        Jogador j = new Jogador();
        j.setNome("Exemplo");
        j.aumentarPontuacao(new Carta("10", 10, "Ouros"));
        assertEquals(Integer.valueOf(10), j.getPontuacao());
    }
    
    @Test
    public void atingiu21VerdadeiroTest() {
        Jogador j = new Jogador();
        j.setNome("Exemplo");
        j.aumentarPontuacao(new Carta("10", 10, "Ouros"));
        j.aumentarPontuacao(new Carta("9", 9, "Ouros"));
        j.aumentarPontuacao(new Carta("2", 2, "Ouros"));
        
        assertTrue(j.atingiu21());
    }
    
    @Test
    public void atingiu21FalsoTest() {
        Jogador j = new Jogador();
        j.setNome("Exemplo");
        j.aumentarPontuacao(new Carta("10", 10, "Ouros"));
        j.aumentarPontuacao(new Carta("9", 9, "Ouros"));
        
        assertFalse(j.atingiu21());
    }
    
    @Test
    public void excedeu21True() {
        Jogador j = new Jogador();
        j.setNome("Exemplo");
        j.aumentarPontuacao(new Carta("10", 10, "Ouros"));
        j.aumentarPontuacao(new Carta("9", 9, "Ouros"));
        j.aumentarPontuacao(new Carta("K", 10, "Ouros"));
        
        assertTrue(j.excedeu21());
    }
    
    @Test
    public void excedeu21False() {
        Jogador j = new Jogador();
        j.setNome("Exemplo");
        j.aumentarPontuacao(new Carta("10", 10, "Ouros"));
        j.aumentarPontuacao(new Carta("9", 9, "Ouros"));
        
        assertFalse(j.excedeu21());
    }
    
}
