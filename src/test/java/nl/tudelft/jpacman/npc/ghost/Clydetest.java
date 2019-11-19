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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * here we create a Class to test the movement of the C'lyde Ghost.
 */
public class Clydetest {
        private GhostMapParser ghostMapParser;
        private PacManSprites pacManSprites = new PacManSprites() ;

        /*
        we instatiate the GhostMapParser and also give the required factories.
         */

    public void InstatiateGhostMapParser(){

            GhostFactory ghostFactory = new GhostFactory(pacManSprites);
            BoardFactory boardFactory = new BoardFactory(pacManSprites);

        PointCalculator pointCalculator = new DefaultPointCalculator();
        LevelFactory levelFactory = new LevelFactory(pacManSprites,ghostFactory,pointCalculator);
        ghostMapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);

        }
     /*
     * we write a test case , when the pacman is  far away from more than 8 places, the Clyde tries to go towards the direction of pacman.
      */
        @Test
    void NoShyness(){

            List<String > list = Arrays.asList(
                "############",
                "#P         C#",
                "#############"
            );
            Level level = ghostMapParser.parseMap(list);

            PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
            Player p = playerFactory.createPacMan();
            level.registerPlayer(p);
            p.setDirection(Direction.EAST);

            Clyde c = Navigation.findUnitInBoard(Clyde.class, level.getBoard());

            assertThat(c.nextAiMove()).isEqualTo(Optional.of(Direction.EAST));

        }

    }

