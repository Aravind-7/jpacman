package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;

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
    @BeforeEach
    void setUp(){
        setCollisions();
    }

}
