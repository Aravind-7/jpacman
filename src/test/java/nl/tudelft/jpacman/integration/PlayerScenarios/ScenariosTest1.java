package nl.tudelft.jpacman.integration.PlayerScenarios;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.Navigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.assertEquals;
import static  org.junit.jupiter.api.Assertions.assertTrue;
import static  org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;

public class ScenariosTest1 {

     private Game game;
     private Launcher launcher;
     private MapParser mapParser;
     private Player player;
     private static final int SCORE = 10;
     private static final int NO_SCORE = 0;


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
     * Scenario S2.1 - this Test case is to check the player consumes a pallet.
     * The score should increase.
     */
    @Test
    public  void playerConsumesPallet(){
        setup("/userMap.txt");
        Square playerSquare = player.getSquare();
        game.move(player, Direction.EAST);
        assertEquals(SCORE, player.getScore());

        Square newPlayerSquare = player.getSquare();
        assertThat(playerSquare.getSquareAt(Direction.EAST)).isEqualTo(newPlayerSquare);

        Unit pallet = Navigation.findUnit(Pellet.class, player.getSquare());
        assertEquals(null,pallet);

    }

    /**
     * Scenario S2.2 - this Test case is to move the player to Emplay square.
     * check that the Score remains same.
     */
    @Test
    public void emptySquare(){
        setup("/userMap.txt");
        Square playerSquare = player.getSquare();
        game.move(player, Direction.WEST);
        assertEquals(NO_SCORE, player.getScore());

        Square newPlayerSquare = player.getSquare();
        assertThat(playerSquare.getSquareAt(Direction.WEST)).isEqualTo(newPlayerSquare);

    }

    /**
     * Scenario S2.3 - this Test cases is to check the movement of player against wall.
     */
    @Test
    public void moveFails(){
        setup("/userMap.txt");
        Square playerSquare = player.getSquare();
        game.move(player, Direction.NORTH);
        assertEquals(playerSquare, player.getSquare());
    }



}
