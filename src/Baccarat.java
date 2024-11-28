import java.util.Scanner;

public class Baccarat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();

        System.out.println("Welcome to the Baccarat game! \nIt's a best of 5 game! \nEither you win 3 times, or the banker wins 3 times.");

        // Main game loop
        while (!gameLogic.isGameOver()) {
            System.out.println("\nStarting new round...");
            boolean result = gameLogic.playRound(input);

            if (!result) {
                System.out.print("\nWould you like to play another round? (yes/no): ");
                String response = input.nextLine().toLowerCase();
                if (!response.equals("yes")) {
                    System.out.println("Thanks for playing! Exiting the game...");
                    break;
                }
            }
        }

        // Print the final results after the game ends
        gameLogic.printFinalResults();
        input.close();
    }
}

