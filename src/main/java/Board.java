public class Board {

    private char[][] ticTacToeBoard;
    private final char DEFAULT_CHAR = '\u0000';

    public Board() {
        this.ticTacToeBoard = new char[3][3];
    }

    public boolean markPlayerInput(Player player, int row, int col) {

        if(row>2 || col>2 || row< 0 || col <0)
            return  false;
        if(ticTacToeBoard[row][col] != DEFAULT_CHAR) {
            return false;
        }
        ticTacToeBoard[row][col] = player.getSign();
        return true;
    }

    public char checkWinner() {
        char sign = DEFAULT_CHAR;
        sign = checkWinningScenarioForCol();
        if(sign == DEFAULT_CHAR) {
            sign = checkWinningScenarioForRow();
        }
        if(sign == DEFAULT_CHAR) {
            sign = checkWinningScenarioForDaigonal();
        }
        return sign;
    }

    public char getValueAtIndex(int row,int col) {
        return ticTacToeBoard[row][col];
    }

    private char checkWinningScenarioForRow() {
        char sign = DEFAULT_CHAR;
        for (int i =0; i < 3; i++ ) {
            if((ticTacToeBoard[i][0] == ticTacToeBoard[i][1]) && ( ticTacToeBoard[i][1] == ticTacToeBoard[i][2])) {
                sign = ticTacToeBoard[i][0] ;
                break;
            }
        }

        return sign;
    }

    private char checkWinningScenarioForCol() {
        char sign = DEFAULT_CHAR;
        for (int i =0; i < 3; i++ ) {
            if((ticTacToeBoard[0][i] == ticTacToeBoard[1][i]) && ( ticTacToeBoard[1][i] == ticTacToeBoard[2][i])) {
                sign = ticTacToeBoard[1][i];
                break;
            }
        }

        return sign;
    }
    private char checkWinningScenarioForDaigonal() {
        char sign = DEFAULT_CHAR;
        if (
                ((ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][2])) ||
                 ((ticTacToeBoard[0][2] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][0]))
            ) {
            sign = ticTacToeBoard[1][1];
        }

        return sign;
    }


    public void printBoard() {
        System.out.println("Board status :") ;
        for (int i =0; i < 3; i++) {
            for (int j =0; j < 3; j++) {
                char val = (ticTacToeBoard[i][j]==DEFAULT_CHAR) ? '*' :ticTacToeBoard[i][j];
                System.out.print(val + "|");
            }
        System.out.println("\n------");
        }
    }
}
