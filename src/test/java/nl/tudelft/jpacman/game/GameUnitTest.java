package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * test suite for Game Unit Test.
 */
public class GameUnitTest {

    private Game game;
    private final Level level = Mockito.mock(Level.class);
    private final Player player = Mockito.mock(Player.class);
    private final PointCalculator pointCalculator = Mockito.mock(PointCalculator.class);


    /**
     * here we create a setUp for a SinglePLayer game before each new game.
     */
    @BeforeEach
    void setUp() {
        game = new SinglePlayerGame(player,level,pointCalculator);
    }

    /**
     * test case for the startGame method.
     */
    @Test
    void startGame() {
        final int randompoint= 10;
        Mockito.when(level.isAnyPlayerAlive()).thenReturn(true);
        Mockito.when(level.remainingPellets()).thenReturn(randompoint);
        game.start();

        Mockito.verify(level).start();
        Mockito.verify(level).addObserver(game);
        assertThat(game.isInProgress()).isTrue();
    }

    /**
     * Test case to check whether the game is in progress or not.
     */
    @Test
    void isInProgress() {
        final int randompoint = 10;
        Mockito.when(level.isAnyPlayerAlive()).thenReturn(true);
        Mockito.when((level.remainingPellets())).thenReturn(randompoint);
        game.start();
        game.start();

        Mockito.verify(level).start();
        Mockito.verify(level).addObserver(game);
        assertThat(game.isInProgress()).isTrue();
    }

    /**
     * test case to che when the Game is over.
     *
     */

    @Test
    void GameOver() {
        final int randompoint =10;
        Mockito.when(level.isAnyPlayerAlive()).thenReturn(false);
        Mockito.when(level.remainingPellets()).thenReturn(randompoint);
        game.start();
        assertThat(game.isInProgress()).isFalse();
    }
}
