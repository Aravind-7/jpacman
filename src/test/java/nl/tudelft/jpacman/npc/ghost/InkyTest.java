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

class InkyTest {

    private PacManSprites pacManSprites = new PacManSprites();
    private GhostFactory ghostFactory = new GhostFactory(pacManSprites);
    private BoardFactory boardFactory = new BoardFactory(pacManSprites);
    private PointCalculator pointCalculator = new DefaultPointCalculator();
    private LevelFactory levelFactory = new LevelFactory(pacManSprites,
        ghostFactory, pointCalculator);
    private GhostMapParser ghostMapParser = new GhostMapParser(levelFactory,
        boardFactory, ghostFactory);

    /**
     * Good weather case-1: Inky moves East.
     */
    @Test
    void inkyMoveEast() {
        List<String> position = Arrays.asList(
            "################",
            "#   B          #",
            "#             P#",
            "#I             #",
            "################");

        Level level = ghostMapParser.parseMap(position);
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player pman = playerFactory.createPacMan();
        level.registerPlayer(pman);
        pman.setDirection(Direction.EAST);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());

        assert inky != null;
        assertEquals(Optional.of(Direction.EAST), inky.nextAiMove());
    }

    /**
     * Good weather case-2: Inky moves West.
     */
    @Test
    void inkyMoveWest(){
        List<String> position = Arrays.asList(
            "################",
            "#   B          #",
            "#P             #",
            "#             I#",
            "################");

        Level level = ghostMapParser.parseMap(position);
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player pman = playerFactory.createPacMan();
        level.registerPlayer(pman);
        pman.setDirection(Direction.WEST);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());

        assert inky != null;
        assertEquals(Optional.of(Direction.WEST), inky.nextAiMove());

    }

}
