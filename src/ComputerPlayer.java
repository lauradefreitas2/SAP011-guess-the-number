package src;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String nome) {
        super(nome);
    }

    @Override
    public int makeGuess() {
        Random random = new Random();
        int suposicao = random.nextInt(100) + 1;
        getGuesses().add(suposicao);
        return suposicao;
    }
}

