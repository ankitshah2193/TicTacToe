import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Player p1;
    private Player p2;

    @BeforeEach
    void setUp() {
        p1 = new Player("Ankit", 'X');
        p2 = new Player("Swapnil", 'O');
        board = new Board();
    }

    @Test
    public void testMarkPlayerInput() {
        boolean isValid = board.markPlayerInput(p1, 1, 1);
        assertTrue(isValid);
        assertEquals('X', board.getValueAtIndex(1, 1));
    }

    @Test
    public void testMarkPlayerInput_Invalid() {
        board.markPlayerInput(p1, 1, 1);
        boolean isInValid = board.markPlayerInput(p1, 1, 1);
        ;
        assertFalse(isInValid);
    }

    @Test
    public void testMarkPlayerInput_Invalid1() {
        boolean isInValid = board.markPlayerInput(p1, 3, 1);
        ;
        assertFalse(isInValid);
    }

    @Test
    public void testMarkPlayerInput_Invalid2() {
        boolean isInValid = board.markPlayerInput(p1, -1, 1);
        ;
        assertFalse(isInValid);
    }

    @Test
    public void testCheckWinner_ForCol() {
        board.markPlayerInput(p1, 1, 1);
        board.markPlayerInput(p2, 0, 0);
        board.markPlayerInput(p1, 0, 1);
        board.markPlayerInput(p2, 0, 2);
        board.markPlayerInput(p1, 2, 1);
        assertEquals('X', board.checkWinner());
    }

    @Test
    public void testCheckWinner_Negative() {
        board.markPlayerInput(p1, 0, 0);
        board.markPlayerInput(p2, 0, 1);
        board.markPlayerInput(p1, 0, 2);
        board.markPlayerInput(p2, 1, 1);
        board.markPlayerInput(p1, 1, 0);
        board.markPlayerInput(p2, 2, 0);
        board.markPlayerInput(p1, 2, 1);
        board.markPlayerInput(p2, 2, 2);
        board.markPlayerInput(p2, 1, 2);
        assertEquals('\u0000', board.checkWinner());
    }

    @Test
    public void testCheckWinner_ForRow() {
        board.markPlayerInput(p1, 0, 0);
        board.markPlayerInput(p2, 1, 0);
        board.markPlayerInput(p1, 2, 1);
        board.markPlayerInput(p2, 1, 1);
        board.markPlayerInput(p1, 2, 2);
        board.markPlayerInput(p2, 1, 2);
        assertEquals('O', board.checkWinner());
    }

    @Test
    public void testCheckWinner_ForDiagonal1() {
        board.markPlayerInput(p1, 0, 0);
        board.markPlayerInput(p2, 2, 0);
        board.markPlayerInput(p1, 1, 1);
        board.markPlayerInput(p2, 2, 1);
        board.markPlayerInput(p1, 2, 2);
        assertEquals('X', board.checkWinner());
    }

    @Test
    public void testCheckWinner_ForDiagonal2() {
        board.markPlayerInput(p1, 0, 0);
        board.markPlayerInput(p2, 0, 2);
        board.markPlayerInput(p1, 1, 0);
        board.markPlayerInput(p2, 1, 1);
        board.markPlayerInput(p1, 2, 1);
        board.markPlayerInput(p2, 2, 0);
        assertEquals('O', board.checkWinner());
    }
}