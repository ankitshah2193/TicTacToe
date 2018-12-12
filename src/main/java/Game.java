public class Game {

    InputReaderClass reader;
    Player player1;
    Player player2;
    Board board;
    private final char DEFAULT_CHAR = '\u0000';

    public Game(InputReaderClass reader) {
        this.reader = reader;
        this.board = new Board();
    }

    public void startGame() {
        int stepCount = 0;
        while (stepCount < 9) {
            Player currentPlayer = stepCount % 2 == 0 ? player1 : player2;
            String[] index = getPlayerInput(currentPlayer);
            boolean isValidInput =  board.markPlayerInput(currentPlayer, Integer.parseInt(index[0]), Integer.parseInt(index[1]));
            if(!isValidInput) {
                System.out.println(currentPlayer.getName() + " ,this is an invalid input");
                continue;
            } else {
                board.printBoard();
                stepCount++;
                char winnerSign = board.checkWinner();
                if(stepCount > 4 && winnerSign!= DEFAULT_CHAR) {
                    printWinner(currentPlayer);
                    break;
                }
            }
        }
    }

    private String[] getPlayerInput(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + ", It's your turn. Please enter value in  row,col format:");
        String value = reader.getInput();
        return value.trim().split(",");
    }

    public void initializeGame() {
        System.out.println("Let's play TicTacToe");
        System.out.println("Player 1, Please enter your name: ");
        String playerOneName = reader.getName();
        this.player1 = new Player(playerOneName, Sign.X);
        System.out.println("Player 2, Please enter your name: ");
        String playerTwoName = reader.getName();
        this.player2 = new Player(playerTwoName,Sign.O);
    }

    private void printWinner(Player player) {
        System.out.println("Congratulations " + player.getName() + " , You are the WINNER!");
    }

}
