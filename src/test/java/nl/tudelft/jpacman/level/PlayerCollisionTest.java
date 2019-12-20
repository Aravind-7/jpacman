package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;

public class PlayerCollisionTest extends CollisionTest{
    @Override
    void setCollisions(){
        PointCalculator pointCalculator = new DefaultPointCalculator();
        CollisionMap collisionMap = new PlayerCollisions(pointCalculator);
        setCollisionMap(collisionMap);
    }


    /**
     * BeforeEach set collision
     */
    void setUp(){
        setCollisions();
    }
}
