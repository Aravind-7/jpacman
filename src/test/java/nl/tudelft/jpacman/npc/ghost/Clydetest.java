package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;

public class Clydetest {
        private GhostMapParser ghostMapParser;
        private PacManSprites pacManSprites = new PacManSprites() ;

    public void InstatiateGhostMapParser(){

            GhostFactory ghostFactory = new GhostFactory(pacManSprites);
            BoardFactory boardFactory = new BoardFactory(pacManSprites);
        PointCalculator pointCalculator = new DefaultPointCalculator();
        LevelFactory levelFactory = new LevelFactory(pacManSprites,ghostFactory,pointCalculator);
        ghostMapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);

        }







    }

