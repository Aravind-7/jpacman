package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;


/**
 * Test class to construct board with out null.
 *
 */
public class BoardTest {


    /**
     * it constructs a board with 1x1 grid.
     */
    @Test
    void board() {

        BasicSquare basicSquare = new BasicSquare();
        Square[][] squares = {{basicSquare}};

        Board board = new Board(squares);

        assertThat(board).isInstanceOf(Board.class);

    }

   /** @Test
    void Nullboard(){

        BasicSquare basicsquare2 = null;
        Square[][] squares2= {{basicsquare2}};

        Board board2 = new Board(squares2);
        Square sq1 = board2.squareAt(0 ,0);



    }
**/
}
