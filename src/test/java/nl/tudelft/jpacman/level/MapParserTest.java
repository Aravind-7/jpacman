package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import nl.tudelft.jpacman.level.LevelFactory;

import java.util.Map;

public class MapParserTest{

    private final LevelFactory levelCreator = Mockito.mock(LevelFactory.class);
    private final BoardFactory boardCreator = Mockito.mock(BoardFactory.class);
    private final Square wall = Mockito.mock(Square.class);
    private final Square ground = Mockito.mock(Square.class);

    private MapParser mapParser;


    @BeforeEach
    void setup(){
        mapParser = new MapParser(levelCreator,boardCreator);
        Mockito.when(boardCreator.createGround()).thenReturn(ground);
        Mockito.when(boardCreator.createWall()).thenReturn(wall);

    }
/**
 *
 */
     @Test
    void forground(){


         mapParser.parseMap(Lists.newArrayList( " "));
         Mockito.verify(boardCreator).createGround();

     }







}
