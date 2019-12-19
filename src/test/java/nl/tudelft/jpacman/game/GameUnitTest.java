package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

public class GameUnitTest {

    private Game game;
    private final Level level = Mockito.mock(Level.class);
    private final Player player = Mockito.mock(Player.class);
    private final LevelFactory levelFactory = Mockito.mock(LevelFactory.class);
    private final PlayerFactory playerFactory = Mockito.mock(PlayerFactory.class);
    private final PointCalculator pointCalculator = Mockito.mock(PointCalculator.class);
    private final GameFactory gameFactory = Mockito.mock(GameFactory.class);


    /**
     * here we create a setUp for a SinglePLayer game before each new game.
     */
    @BeforeEach
    void setUp(){
        game = new SinglePlayerGame(player,level,pointCalculator);
    }

    /**
     * test case for the startGame method.
     */

    @Test
    void startGame() {
        Mockito.when(level.isAnyPlayerAlive()).thenReturn(true);
        Mockito.when(level.remainingPellets()).thenReturn(2);
        game.start();
        assertThat(game.isInProgress()).isTrue();
    }
}
