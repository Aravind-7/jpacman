package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * here we create a Class to test the movement of the C'lyde Ghost.
 */
public class Clydetest {

    private PacManSprites pacManSprites = new PacManSprites();
    private GhostFactory ghostFactory = new GhostFactory(pacManSprites);
    private BoardFactory boardFactory = new BoardFactory(pacManSprites);
    private PointCalculator pointCalculator = new DefaultPointCalculator();
    private LevelFactory levelFactory = new LevelFactory(pacManSprites,
        ghostFactory, pointCalculator);
    private GhostMapParser ghostMapParser = new GhostMapParser(levelFactory,
        boardFactory, ghostFactory);

    /**
     * Good weather case.
     *Here we create a test case that the pacman is far away from the clyde by more than 8.
     * And the clyde tries to move in the direction of pacman.
     */
    @Test
        void no_Shyness() {

        List<String> position = Arrays.asList(
                "############",
                "#P        C#",
                "############"
        );
        Level level = ghostMapParser.parseMap(position);

        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player p = playerFactory.createPacMan();
        level.registerPlayer(p);
        p.setDirection(Direction.WEST);

        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());

        assert clyde != null;
        assertEquals(Optional.of(Direction.WEST), clyde.nextAiMove());

    }
}


