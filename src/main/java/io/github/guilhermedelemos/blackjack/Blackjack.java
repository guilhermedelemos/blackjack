package io.github.guilhermedelemos.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

    private Baralho baralho;
    private Jogador jogador1;
    private Jogador computador;

    public void executar() {
        System.out.println("Jogo 21");

        /**
         * *** instanciar jogadores ****
         */
        this.jogador1 = new Jogador();
        // perguntar nome do Jogador

        this.computador = new Jogador();
        this.computador.setNome("COMPUTADOR");

        /**
         * *** inicializar baralho ****
         */
        this.baralho = new Baralho();

        /**
         * *** JOGAR ****
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o seu nome");
        jogador1.setNome(scanner.next());

        System.out.println("Boa sorte");
        System.out.println();

        boolean jogarNovamente = true;
        do {
            boolean continuar = true;
            List<Carta> mesa = new ArrayList<>();
            do {
                Carta cartaPuxada = this.baralho.puxar();
                mesa.add(cartaPuxada);
                jogador1.aumentarPontuacao(cartaPuxada);
                System.out.println("Você puxou a carta " + cartaPuxada.getNome() + " de " + cartaPuxada.getNaipe());
                System.out.println("Sua pontuação é " + jogador1.getPontuacao());
                if (jogador1.atingiu21()) {
                    System.out.println("Você venceu. Parabéns!");
                    break;
                } else if (jogador1.excedeu21()) {
                    System.out.println("Você perdeu.");
                    break;
                }
                System.out.println("Deseja continuar? S/N");
                continuar = scanner.next().toUpperCase().equals("S");
            } while (continuar);

            /**
             * *** COMPUTADOR ****
             */
            do {
                Carta cartaPuxada = this.baralho.puxar();
                mesa.add(cartaPuxada);
                computador.aumentarPontuacao(cartaPuxada);
                System.out.println("O computador puxou a carta " + cartaPuxada.getNome() + " de " + cartaPuxada.getNaipe());
                System.out.println("A pontuação é " + computador.getPontuacao());
                if (computador.atingiu21()) {
                    System.out.println("O computador venceu.");
                    break;
                } else if (computador.excedeu21()) {
                    System.out.println("O computador perdeu.");
                    break;
                } else {
                    continuar = computador.getPontuacao() < jogador1.getPontuacao(); // o computador sempre busca a vitória
                }
            } while (continuar);

            System.out.println("-----");
            System.out.println("Placar:");
            System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao());
            System.out.println(computador.getNome() + ": " + computador.getPontuacao());
            if (jogador1.getPontuacao() > computador.getPontuacao()) {
                System.out.println("Você venceu. Parabéns.");
            } else if (computador.getPontuacao() > jogador1.getPontuacao()) {
                System.out.println("O computador venceu.");
            } else {
                System.out.println("Empate.");
            }
            
            System.out.println("Deseja jogar novamente? S/N");
            jogarNovamente = scanner.next().toUpperCase().equals("S");
            
            baralho.reembaralhar(mesa);
        } while (jogarNovamente);

        //reembaralhar
        //this.baralho.reembaralhar(cartasDaMesa);
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getComputador() {
        return computador;
    }

    public void setComputador(Jogador computador) {
        this.computador = computador;
    }

}
