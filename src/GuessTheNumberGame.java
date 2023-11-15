package src;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int numeroAlvo;

    public static void main(String[] args) {
        exibirMensagemBoasVindas();
        inicializarJogo();
        Player jogadorHumano = new HumanPlayer(getNomeJogador());
        Player jogadorComputador = new ComputerPlayer("Computador");
        int maxTentativas = 20;
        jogarJogo(jogadorHumano, jogadorComputador, maxTentativas);
    }

    public static void exibirMensagemBoasVindas() {
        System.out.println("Bem-vindo ao jogo Adivinhe o Número!");
        System.out.println("Você tem 20 tentativas. Boa sorte!\n");
    }

    public static String getNomeJogador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o seu nome: ");
        return scanner.nextLine();
    }

    public static void inicializarJogo() {
        numeroAlvo = random.nextInt(100) + 1;
    }

    public static int jogarJogo(Player jogadorHumano, Player jogadorComputador, int maxTentativas) {
        int tentativas = 0;

        while (tentativas < maxTentativas) {
            int suposicaoHumano = jogadorHumano.makeGuess();
            System.out.println(jogadorHumano.getName() + " supõe: " + suposicaoHumano);
            tentativas++;

            if (suposicaoHumano == numeroAlvo) {
                System.out.println(jogadorHumano.getName() + " acertou o número correto! É " + suposicaoHumano + ". Fim de jogo!");
                imprimirTodasSuposicoes(jogadorHumano);
                return 0;
            } else if (suposicaoHumano < numeroAlvo) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Muito alto!");
            }

            int suposicaoComputador = jogadorComputador.makeGuess();
            System.out.println(jogadorComputador.getName() + " supõe: " + suposicaoComputador);
            tentativas++;

            if (suposicaoComputador == numeroAlvo) {
                System.out.println(jogadorComputador.getName() + " acertou o número correto! É " + suposicaoComputador + ". Fim de jogo!");
                imprimirTodasSuposicoes(jogadorComputador);
                return 0;
            } else if (suposicaoComputador < numeroAlvo) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Muito alto!");
            }
        }

        System.out.println("Fim de jogo! O número de tentativas máximo foi alcançado.");
        return 1;
    }

    public static void imprimirTodasSuposicoes(Player jogador) {
        System.out.println(jogador.getName() + " fez as seguintes suposições:");
        for (int suposicao : jogador.getGuesses()) {
            System.out.print(suposicao + " ");
        }
        System.out.println();
    }
}
