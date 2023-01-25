import java.util.Scanner;

public class Game {

    private static boolean gameEnded = false;
    public static void main(String[] args) {
        Player playerOne, playerTwo;
        Scanner scanner = new Scanner(System.in);
        System.out.println("State Player 1 name:");
        String playerOneName = scanner.nextLine();
        playerOne = new Player(playerOneName);
        while (true) {
            System.out.println("Would you like to play against another player or the computer?");
            System.out.println("Play against a player? (y/n):");
            char choice = scanner.nextLine().toLowerCase().charAt(0);
            if (choice != 'y' && choice != 'n') {continue;}
            if (choice == 'y') {
                System.out.println("State Player 2 name:");
                String playerTwoName = scanner.nextLine();
                playerTwo = new Player(playerTwoName);
            } else {
                playerTwo = new Computer("Computer");
            }
            break;
        }
        while (!gameEnded) {
            playerOne.chooseAction(scanner, playerTwo);
            playerTwo.chooseAction(scanner, playerOne);
        }
        scanner.close();
    }

    public static void endGame(Player winner) {
        System.out.println("Game has ended! " + winner.getName() + " has won the game!");
        gameEnded = true;
    }
}
