package test;
import org.junit.jupiter.api.Test;
import src.ComputerPlayer;
import src.GuessTheNumberGame;
import src.HumanPlayer;
import src.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessTheNumberGameTest {
    @Test
    public void testHumanPlayerMakeGuess() {
        HumanPlayer player = new HumanPlayer("Fulana");


        player.setManualGuess(42);

        int guess = player.makeGuess();

        assertEquals(42, guess);
    }


    @Test
    public void testComputerPlayerMakeGuess() {

        ComputerPlayer player = new ComputerPlayer("Computer");

        int guess = player.makeGuess();

        assertTrue(guess >= 1 && guess <= 100);
    }

    @Test
    public void testGamePlay() {
        GuessTheNumberGame.inicializarJogo();
        Player jogador = new ComputerPlayer("Computador");
        int maxTentativas = 10;
        int result = GuessTheNumberGame.jogarJogo(jogador, maxTentativas);
        assertTrue(result == 0 || result == 1);
    }



}

