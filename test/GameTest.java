import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.testng.Assert;

import static org.mockito.Mockito.when;


class GameTest {

    Game game;
    Player p1;
    Player p2;
    InputReaderClass mockReader;

    @BeforeEach
    void setUp() {
        mockReader = Mockito.mock(InputReaderClass.class);
        when(mockReader.getName()).thenReturn("Ankit").thenReturn("Swapnil");
        game = new Game(mockReader);
    }

    @AfterEach
    void tearDown() {
        p1 = null;
        p2 = null;

        game = null;
    }

    @Test
    public void testInitializeGame() {
        game.initializeGame();
        Assert.assertEquals("Ankit", game.player1.getName());
        Assert.assertEquals('X', game.player1.getSign());
        Assert.assertEquals("Swapnil", game.player2.getName());
        Assert.assertEquals('O', game.player2.getSign());
    }

    @Test
    public void testStartGame() {
        game.startGame();
    }

}