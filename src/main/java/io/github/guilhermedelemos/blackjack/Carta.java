package io.github.guilhermedelemos.blackjack;

public class Carta {
    
    private String nome;
    private Integer valor;
    private String naipe;

    public Carta() {
        super();
    }

    public Carta(String nome, Integer valor, String naipe) {
        this.nome = nome;
        this.valor = valor;
        this.naipe = naipe;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
    
    
}
