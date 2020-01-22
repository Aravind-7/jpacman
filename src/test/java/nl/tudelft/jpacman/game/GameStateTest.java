package nl.tudelft.jpacman.game;


import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;
import  static org.mockito.Mockito.*;
/**
 * Game State machine test.
 */
public class GameStateTest {

    private Game game;
    private String mapFile = "/StateMap.txt";

    @Mock
    private Level.LevelObserver observer;

    /**
     * start the game and change state to Playing.
     */
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        Launcher launch = (new Launcher()).withMapFile(mapFile);
        game = launch.makeGame();
        game.getLevel().addObserver(observer);
    }

    /**
     * Revealing map so that extensions can use it.
     */
    protected String getMapFile() {
        return mapFile;
    }

    /**
     * Revealing the game so that extensions can use it.
     */
    protected Game getGame() {
        return game;
    }

    /**
     * Setting game to test.
     *
     * @param game is the game.
     */
    protected void setGame(Game game) {
        this.game = game;
    }

    /**
     * Revealing the level observer so that, extensions can use it.
     */
    protected Level.LevelObserver getObserver() {
        return observer;
    }

    /**
     * revealing the player so that, extensions can use it.
     */
    protected Player getPlayer() {
        return getGame().getPlayers().get(0);
    }

    /**
     * Test for zero interactions before the start of game
     */

    @Test
    void beforeStart() {
        //when game is not started nothing can be done.
        getGame().move(getPlayer(), Direction.EAST);
        assertThat(getGame().isInProgress()).isFalse();
        verifyNoMoreInteractions(observer);
    }
    /**
     * Test for gamePlaying to gameWin State.
     */
    @Test
    void gameWin() {
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        getGame().move(getPlayer(),Direction.EAST);
        getGame().move(getPlayer(),Direction.EAST);
        getGame().move(getPlayer(),Direction.EAST);
        verify(observer).levelWon();
        assertThat(getGame().isInProgress()).isFalse();
    }

    /**
     * Game is in gamePlaying State.
     */
    @Test
    void gamePlaying() {
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        getGame().move(getPlayer(),Direction.EAST);
        assertThat(getPlayer().isAlive()).isTrue();
        verifyZeroInteractions(observer);
        assertThat(getGame().isInProgress()).isTrue();
    }

    /**
     * Test for gamePlaying to gameLose State
     */
    @Test
    void gameLose() {
        getGame().start();
        getGame().move(getPlayer(),Direction.WEST);
        getGame().move(getPlayer(),Direction.WEST);
        assertThat(getPlayer().isAlive()).isFalse();
        verify(observer).levelLost();
        assertThat(getGame().isInProgress()).isFalse();
    }

    /**
     * Events having no effect in gamePlaying.
     */
    @Test
    void noEffectInGamePlaying() {
        getGame().start();
        getGame().start();
        verifyZeroInteractions(observer);
        assertThat(getGame().isInProgress()).isTrue();
    }

    /**
     * Events having no effect in gameWin State.
     */
    @Test
    void noEffectInGameWin() {
        gameWin();
        getGame().move(getPlayer(),Direction.EAST);
        getGame().stop();
        getGame().start();
        assertThat(getGame().isInProgress()).isFalse();
        verifyNoMoreInteractions(observer);

    }

    /**
     * Events having no effect in gameLose State.
     */
    @Test
    void noEffectInGameLose() {
        gameLose();
        getGame().move(getPlayer(),Direction.EAST);
        getGame().stop();
        getGame().start();
        assertThat(getGame().isInProgress()).isFalse();
        verifyNoMoreInteractions(observer);
    }

    /**
     * Test for gamePlaying State to gamePause State
     */
    @Test
    void gamePause() {
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        getGame().stop();
        assertThat(getGame().isInProgress()).isFalse();
        verifyZeroInteractions(observer);
    }
    /**
     * Test for gameResume.
     */
    @Test
    void gameResume() {
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        getGame().stop();
        assertThat(getGame().isInProgress()).isFalse();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        verifyZeroInteractions(observer);
    }

    /**
     * Events having no effect in gamePause State.
     */
    @Test
    void noEffectInPause() {
        getGame().start();
        getGame().stop();
        getGame().move(getPlayer(),Direction.EAST);
        getGame().move(getPlayer(),Direction.WEST);
        getGame().stop();
    }

}
