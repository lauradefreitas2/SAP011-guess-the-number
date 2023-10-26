package src;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int numeroAlvo;

    public static void main(String[] args) {
        inicializarJogo();
        Player jogador = getPlayer();
        jogarJogo(jogador);
    }

    public static void inicializarJogo() {
        numeroAlvo = random.nextInt(100) + 1;
    }

    public static Player getPlayer() {
        Scanner scanner = new Scanner(System.in);
        Player jogador = null;

        System.out.println("Escolha o tipo de jogador:");
        System.out.println("1. Jogador Humano");
        System.out.println("2. Jogador Computador");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            System.out.print("Digite o seu nome: ");
            String nome = scanner.nextLine();
            jogador = new HumanPlayer(nome);
        } else if (escolha == 2) {
            jogador = new ComputerPlayer("Computador");
        } else {
            System.out.println("Escolha inválida. Configurando para Jogador Computador.");
            jogador = new ComputerPlayer("Computador");
        }

        return jogador;
    }

    public static void jogarJogo(Player jogador) {
        Player jogadorComputador = new ComputerPlayer("Computador");

        while (true) {
            int suposicao = jogador.makeGuess();
            System.out.println(jogador.getName() + " supõe: " + suposicao);

            if (suposicao == numeroAlvo) {
                System.out.println(jogador.getName() + " acertou o número correto! É " + suposicao + ". Fim de jogo!");
                imprimirTodasSuposicoes(jogador);
                break;
            } else if (suposicao < numeroAlvo) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Muito alto!");
            }

            // Alternar entre o jogador e o computador
            Player temp = jogador;
            jogador = jogadorComputador;
            jogadorComputador = temp;
        }
    }

    public static void imprimirTodasSuposicoes(Player jogador) {
        System.out.println(jogador.getName() + " fez as seguintes suposições:");
        for (int suposicao : jogador.getGuesses()) {
            System.out.print(suposicao + " ");
        }
        System.out.println();
    }
}

