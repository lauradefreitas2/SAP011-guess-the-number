package src;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private int manualGuess = -1;

    public HumanPlayer(String nome) {
        super(nome);
    }

    public HumanPlayer(String nome, int initialGuess) {
        super(nome);
        this.manualGuess = initialGuess;
    }

    public void setManualGuess(int guess) {
        this.manualGuess = guess;
    }

    @Override
    public int makeGuess() {
        if (manualGuess != -1) {
            getGuesses().add(manualGuess);
            return manualGuess;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print(getName() + ", digite a sua suposição: ");
            int suposicao = scanner.nextInt();
            getGuesses().add(suposicao);
            return suposicao;
        }
    }
}


