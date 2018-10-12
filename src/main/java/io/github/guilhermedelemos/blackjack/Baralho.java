package io.github.guilhermedelemos.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    
    private List<Carta> baralho;

    public Baralho() {
        this.baralho = new ArrayList<>();
        
        //Carta c = new Carta();
        //c.setNome("teste");
        
        // Exemplo manual
        this.baralho.add( new Carta("A", 10, "Ouros") );
        this.baralho.add( new Carta("A", 10, "Copas") );
        this.baralho.add( new Carta("A", 10, "Espadas") );
        this.baralho.add( new Carta("A", 10, "Paus") );
        
        // Exemplo semi-automatico
        String[] naipe = {"Ouros", "Copas", "Espadas", "Paus"};
        for(int i=0;i<4;i++) {
            this.baralho.add( new Carta("J", 10, naipe[i]) );
            this.baralho.add( new Carta("Q", 10, naipe[i]) );
            this.baralho.add( new Carta("K", 10, naipe[i]) );
        }
        
        // Exemplo automático
        for(int j=2;j<=10;j++) {
            for(int k=0; k<4; k++) {
                this.baralho.add( new Carta(Integer.toString(j), j, naipe[k]) );
            }
        }
        
        this.embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(this.baralho);
    }
    
    public Carta puxar() {
        return this.baralho.remove(0);
    }
    
    public void reembaralhar(List<Carta> cartas) {
        this.baralho.addAll(cartas);
        this.embaralhar();
    }
    
    public List<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(List<Carta> baralho) {
        this.baralho = baralho;
    }
    
}
