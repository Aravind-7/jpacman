package nl.tudelft.jpacman.integration.PlayerScenarios;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenariosTest2 {

    private Game game;
    private Launcher launcher;
    private Player player;
    private static final int SCORE = 10;



    /**
     *Starts the Launcher.
     */
    @BeforeEach
    public  void  before(){
        launcher = new Launcher();
        launcher.launch();
        game = launcher.getGame();
        game.start();
    }

    /**
     * Closes the Launcher.
     */
    @AfterEach
    public  void  after(){
        launcher.dispose();
    }

    /**
     * Here we make the launcher launch with our user specific map.
     * @param path this is the path of the usermap.
     */

    public void setup(String path){
        launcher.dispose();
        launcher = new Launcher();
        launcher = launcher.withMapFile(path);
        launcher.launch();
        game = launcher.getGame();
        game.start();
        player = game.getPlayers().get(0);
    }

    /**
     * Scenario S2.4 - This Test is to check that player dies when it meets Ghost.
     */
    @Test
    public void pacmanVsGhost(){
        setup("/GameLost.txt");
        game.move(player, Direction.WEST);

        assertThat(player.isAlive()).isFalse();
        assertThat(game.isInProgress()).isFalse();
    }

    /**
     *
     */
    @Test
    public  void playerWins(){
        setup("/userMap.txt");
        game.move(player, Direction.EAST);
        assertEquals(SCORE, player.getScore());

        assertThat(player.isAlive()).isTrue();
        assertThat(game.getLevel().remainingPellets()).isEqualTo(0);
        assertThat(game.isInProgress()).isFalse();
    }

}
