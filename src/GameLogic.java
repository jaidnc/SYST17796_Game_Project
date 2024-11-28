import java.util.Scanner;

public class GameLogic {
    private int userWins = 0;      // Tracks user wins
    private int bankerWins = 0; // Tracks banker wins
    private int rounds = 0;       // Tracks total rounds played

    public boolean playRound(Scanner input) {
        rounds++;
        System.out.print("Please type either 'Player' or 'Banker' to place your bet: ");
        String bet = input.nextLine().toLowerCase();

        // Generate hands for player and banker
        Card[] playerHand = generateHand();
        Card[] bankerHand = generateHand();

        System.out.println("\nPlayer hand: ");
        printHand(playerHand);
        System.out.println("Banker hand: ");
        printHand(bankerHand);

        // Calculate initial scores
        int playerScore = ScoreCalculator.calculateScore(playerHand);
        int bankerScore = ScoreCalculator.calculateScore(bankerHand);

        System.out.println("\nInitial Scores - Player: " + playerScore + ", Banker: " + bankerScore);

        // Apply third card rules
        if (Card.needsThirdCard(playerScore, true) && bankerScore < 8) {
            Card thirdCard = new Card((int) (Math.random() * 13 + 1));
            System.out.println("Player draws: " + thirdCard);
            playerScore = ScoreCalculator.calculateScore(playerHand, thirdCard);
        }
        if (Card.needsThirdCard(bankerScore, false) && playerScore < 8) {
            Card thirdCard = new Card((int) (Math.random() * 13 + 1));
            System.out.println("Banker draws: " + thirdCard);
            bankerScore = ScoreCalculator.calculateScore(bankerHand, thirdCard);
        }

        System.out.println("\nFinal Scores - Player: " + playerScore + ", Banker: " + bankerScore);

        // Determine winner
        boolean userWon = false;
        if (playerScore > bankerScore) {
            System.out.println("Player wins this round!");
            userWon = bet.equals("player");
        } else if (bankerScore > playerScore) {
            System.out.println("Banker wins this round!");
            userWon = bet.equals("banker");
        } else {
            System.out.println("It's a tie!");
        }

        // Update scores
        if (userWon) {
            userWins++;
            System.out.println("You won your bet!");
        } else {
            bankerWins++;
            System.out.println("You lost your bet!");
        }

        return userWon;
    }

    public boolean isGameOver() {
        // End game after 5 rounds or if either user or bankers wins 3 times
        return rounds >= 5 || userWins >= 3 || bankerWins >= 3;
    }

    public void printFinalResults() {
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Your Total Wins: " + userWins);
        System.out.println("Banker's Total Wins: " + bankerWins);

        if (userWins >= 3) {
            System.out.println("Congratulations! You won the game by getting 3 wins!");
        } else if (bankerWins >= 3) {
            System.out.println("Sorry, the banker won the game with 3 wins!");
        } else if (userWins > bankerWins) {
            System.out.println("You won the game with more wins overall!");
        } else if (bankerWins > userWins) {
            System.out.println("The banker won the game with more wins overall!");
        } else {
            System.out.println("The game ended in a tie!");
        }
    }

    private Card[] generateHand() {
        return new Card[]{new Card((int) (Math.random() * 13 + 1)), new Card((int) (Math.random() * 13 + 1))};
    }

    private void printHand(Card[] hand) {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}