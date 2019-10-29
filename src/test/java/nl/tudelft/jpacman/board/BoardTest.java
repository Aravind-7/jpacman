package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    void board(){

        BasicSquare basicSquare = new BasicSquare();
        Square[][] squares= {{basicSquare}};

        Board board = new Board(squares);
        Square sq0 = board.squareAt(0,0);
        assertThat(board).isInstanceOf(Board.class);

    }

    @Test
    void Nullboard(){

        BasicSquare basicsquare2 = null;
        Square[][] squares2= {{basicsquare2}};

        Board board2 = new Board(squares2);
        Square sq1 = board2.squareAt(0,0);



    }

}
