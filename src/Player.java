package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String nome;
    private List<Integer> suposicoes = new ArrayList<>();

    public Player(String nome) {
        this.nome = nome;
    }

    public String getName() {
        return nome;
    }

    public List<Integer> getGuesses() {
        return suposicoes;
    }

    public abstract int makeGuess();
}

