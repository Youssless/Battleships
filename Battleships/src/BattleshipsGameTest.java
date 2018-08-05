import java.util.Scanner;

public class BattleshipsGameTest {

    public static void main(String[] args) {
        //game.printShips();
        BattleshipsGameTest test = new BattleshipsGameTest();
        test.gameTest();
    }

    private void gameTest() {
        Scanner input = new Scanner(System.in);
        BattleshipsGame game = new BattleshipsGame();
        game.printBoard();
        System.out.println();
        game.placeShips(3);
        game.placeShips(4);
        game.placeShips(5);
        game.placeShips(3);
        game.placeShips(2);

        while (game.hasEnded() == false) {
            System.out.print("Enter row number: ");
            int rowInput = input.nextInt();
            System.out.print("Enter column number: ");
            int colInput = input.nextInt();
            game.shoot(rowInput, colInput);
            game.printBoard();
            System.out.println(game.getBullets() + " bullets remaining");

            if (game.hasEnded() == true)
                System.exit(0);
        }
    }
}
