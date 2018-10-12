package io.github.guilhermedelemos.blackjack;

public class Jogador {

    private String nome;
    private Integer pontuacao;

    public Jogador() {
        this.pontuacao = 0;
    }
    
    public boolean atingiu21() {
        return pontuacao == 21;
    }
    
    public boolean excedeu21() {
        return pontuacao > 21;
    }
    
    public void aumentarPontuacao(Carta carta) {
        this.pontuacao += carta.getValor();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    
}
