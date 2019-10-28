package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
    /**
     * Do we get the correct delta when moving north?
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
        assertThat(north.getDeltaX()).isEqualTo(0);
    }

    /**
     * Test case for correct movement in SOUTH Direction.
     */

    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
        assertThat(south.getDeltaX()).isEqualTo(0);
    }

    /**
     * Test case for correct movement in WEST Direction.
     */
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaY()).isEqualTo(0);
        assertThat(west.getDeltaX()).isEqualTo(-1);
    }


    /**
     * Test case for checking correct movement in EAST direction.
     */
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaY()).isEqualTo(0);
        assertThat(east.getDeltaX()).isEqualTo(1);
    }


}

