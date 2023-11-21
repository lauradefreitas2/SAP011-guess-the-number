package test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import src.ComputerPlayer;
import src.GuessTheNumberGame;
import src.HumanPlayer;
import src.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class GuessTheNumberGameTest {
    @Test
    public void testHumanPlayerMakeGuess() {
        HumanPlayer player = Mockito.mock(HumanPlayer.class);
        when(player.makeGuess()).thenReturn(42);

        int guess = player.makeGuess();

        assertEquals(42, guess);
    }

    @Test
    public void testComputerPlayerMakeGuess() {
        ComputerPlayer player = Mockito.mock(ComputerPlayer.class);
        when(player.makeGuess()).thenReturn(50);

        int guess = player.makeGuess();

        assertTrue(guess >= 1 && guess <= 100);
    }

    @Test
    public void testGamePlay() {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.inicializarJogo();


        HumanPlayer jogadorHumano = Mockito.mock(HumanPlayer.class);
        when(jogadorHumano.makeGuess()).thenReturn(50);

        ComputerPlayer jogadorComputador = Mockito.mock(ComputerPlayer.class);
        when(jogadorComputador.makeGuess()).thenReturn(30);

        int maxTentativas = 10;
        int result = game.jogarJogo(jogadorHumano, jogadorComputador, maxTentativas);
        assertTrue(result == 0 || result == 1);
    }
    @Test
    public void testGamePlayMaxAttemptsReached() {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.inicializarJogo();

        Player jogadorHumano = Mockito.mock(HumanPlayer.class);
        when(jogadorHumano.makeGuess()).thenReturn(30);

        Player jogadorComputador = Mockito.mock(ComputerPlayer.class);
        when(jogadorComputador.makeGuess()).thenReturn(40);

        int maxTentativas = 1;
        int result = game.jogarJogo(jogadorHumano, jogadorComputador, maxTentativas);

        assertEquals(1, result);
    }


}

