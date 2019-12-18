package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * create a test class.
 */
public class MapParserTest {
    private final LevelFactory levelCreator = Mockito.mock(LevelFactory.class);
    private final BoardFactory boardCreator = Mockito.mock(BoardFactory.class);
    private final Square wall = Mockito.mock(Square.class);
    private final Square ground = Mockito.mock(Square.class);
    private final Square palletSquare = Mockito.mock(Square.class);
    private final Square playersquare = Mockito.mock(Square.class);
    private final Square ghostSquare = Mockito.mock(Square.class);
    private final Pellet pellet = Mockito.mock(Pellet.class);
    private final Ghost ghost = Mockito.mock(Ghost.class);

    private MapParser mapParser;


    /**
     * create a before each.
     */
    @BeforeEach
    void setup() {
        mapParser = new MapParser(levelCreator, boardCreator);
        Mockito.when(boardCreator.createGround()).thenReturn(ground);
        Mockito.when(boardCreator.createWall()).thenReturn(wall);
        Mockito.when(levelCreator.createPellet()).thenReturn(pellet);
        Mockito.when(boardCreator.createGround()).thenReturn(playersquare);
        Mockito.when(boardCreator.createGround()).thenReturn(ghostSquare);
        Mockito.when(boardCreator.createGround()).thenReturn(palletSquare);
        Mockito.when(levelCreator.createGhost()).thenReturn(ghost);
    }


/**
 *Niceweather test for checking ground is created when empty space is passed.
 */
    @Test
    void forGround() {
        mapParser.parseMap(Lists.newArrayList(" "));
        Mockito.verify(boardCreator).createGround();
    }

    /**
     * Nice weather test for checking if wall is created when "#" is passed.
     */

    @Test
    void forWall() {
        mapParser.parseMap(Lists.newArrayList("#"));
        Mockito.verify(boardCreator).createWall();
    }

    /**
     * Nice weather test for creating a pallet in the square.
     */

    @Test
    void forPallet() {
        mapParser.parseMap(Lists.newArrayList("."));
        Mockito.verify(boardCreator).createGround();
        Mockito.verify(levelCreator).createPellet();
        Mockito.verify(pellet).occupy(palletSquare);
    }

    /**
     * Nice weather test for creating a player.
     */

    @Test
    void forPlayer() {
        mapParser.parseMap(Lists.newArrayList("P"));
        Mockito.verify(boardCreator).createGround();
        Mockito.verify(levelCreator).createLevel(Mockito.any(),
            Mockito.anyList(), Mockito.anyList());

    }

}
