package nl.tudelft.jpacman.integration.suspension;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuspendTest {

    private Launcher launcher;

    /**
     * Launch a launcher ,which can display the game interface.
     */

    @BeforeEach
    public void before(){
        launcher = new Launcher();
    }

    /**
     * After clicking the stop button, end the game interface.
     */

    @AfterEach
    public  void  after(){
        launcher.dispose();
    }

    /**
     *Test case for checking that the game is in progress.
     */

    @Test
    public void gameInProgress(){

        launcher.launch();
        getGame().start();

        assertThat(getGame().isInProgress()).isTrue();

    }

    /**
     * Test case to suspend the game , when stop button is pressed.
     */

    @Test
    public void gameIsSuspended(){

        launcher.launch();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        getGame().stop();
        assertThat(getGame().isInProgress()).isFalse();

    }

    private Game getGame(){
        return launcher.getGame();
    }

}
