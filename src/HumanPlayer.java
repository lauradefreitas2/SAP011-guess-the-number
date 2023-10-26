package src;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String nome) {
        super(nome);
    }

    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(getName() + ", digite a sua suposição: ");
        int suposicao = scanner.nextInt();
        getGuesses().add(suposicao);
        return suposicao;
    }
}

