package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * create a test class.
 */
public class MapParserTest{
    private final LevelFactory levelCreator = Mockito.mock(LevelFactory.class);
    private final BoardFactory boardCreator = Mockito.mock(BoardFactory.class);
    private final Square wall = Mockito.mock(Square.class);
    private final Square ground = Mockito.mock(Square.class);
    private MapParser mapParser;

    /**
     * create a before each.
     */
    @BeforeEach
    void setup(){
        mapParser = new MapParser(levelCreator,boardCreator);
        Mockito.when(boardCreator.createGround()).thenReturn(ground);
        Mockito.when(boardCreator.createWall()).thenReturn(wall);
    }
/**
 *test to verify the ground.
 */
    @Test
    void forground(){
         mapParser.parseMap(Lists.newArrayList( " "));
         Mockito.verify(boardCreator).createGround();
     }
}
