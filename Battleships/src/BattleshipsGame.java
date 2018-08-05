public class BattleshipsGame {
    private int[][] board;
    private int[][] shipPlacement;
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private int bullets = 50;

    public BattleshipsGame() {
        board = new int[ROWS][COLS];
        shipPlacement = new int[ROWS][COLS];

        // initialising whole board to 0's
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = 0;
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(shipPlacement[i][j] + " ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printShips() {
        for (int i = 0; i < shipPlacement.length; i++) {
            for (int j = 0; j < shipPlacement[i].length; j++)
                System.out.print(shipPlacement[i][j] + " ");
            System.out.println();
        }
    }

    public void placeShips(int shipLength) {
        int rowPos = (int)(Math.random() * 9);
        int colPos = (int)(Math.random() * 9);
        shipLength = shipLength + 1;

        for (int i = 0; i < shipLength - 1; i++) {
            if (colPos < 10) {
                if (shipPlacement[rowPos][colPos] == 3)
                    shipPlacement[colPos][rowPos] = 3;
                else
                    shipPlacement[rowPos][colPos] = 3;
                colPos = colPos + 1;
            } else {
                colPos = colPos - rowPos;
            }

        }
    }

    public void shoot(int rowPos, int colPos) {
        if (shipPlacement[rowPos][colPos] == 3) {
            shipPlacement[rowPos][colPos] = 0;
            System.out.println("HIT!");
            bullets--;
        }
        else {
            shipPlacement[rowPos][colPos] = 9;
            System.out.println("MISS");
            bullets--;
        }

    }

    public boolean hasEnded() {
        if (bullets == 0)
            return true;
        else
            return false;
    }

    public int getBullets() {
        return bullets;
    }
}
