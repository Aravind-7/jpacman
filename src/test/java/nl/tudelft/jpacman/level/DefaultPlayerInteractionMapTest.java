package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;

public class DefaultPlayerInteractionMapTest extends CollisionTest{
    @Override
    void setCollisions() {
        PointCalculator pointCalculator = new DefaultPointCalculator();
        CollisionMap collisionMap = new DefaultPlayerInteractionMap(pointCalculator);
        setCollisionMap(collisionMap);
    }

    /**
     * BeforeEach setup CollisionMap.
     */
    @BeforeEach
    void setUpDefault(){
        setCollisions();
    }

}
