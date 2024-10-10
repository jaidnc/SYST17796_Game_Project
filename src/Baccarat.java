import java.util.Scanner;

public class Baccarat {
  
    public static void main (String [] arg){
            Scanner input = new Scanner(System.in);

            System.out.println("Please select either 'Player' or 'Banker' for your bet: ");
            String bet = input.nextLine().toLowerCase();

            // Array to represent a hand of 2 cards
            Card[] playerHand = new Card[2];  // Assuming you have a Card class
            Card[] bankerHand = new Card[2];  // Assuming you have a Card class 

            // Genereate random cards for players hand  
            for (int i = 0; i < playerHand.length; i++) {
                int cardValue = (int) (Math.random() * 13 + 1);  
                playerHand[i] = new Card(cardValue);  
            }

            // Generate random cards for bankers hand
            for (int i = 0; i < bankerHand.length; i++) {
                int cardValue = (int) (Math.random() * 13 + 1);  
                bankerHand[i] = new Card(cardValue);  
            }
    
            // Print the generated hand for testing purposes
            System.out.println("Player hand is: ");
            for (Card card : playerHand) {
                System.out.println(card);
            }
            
            System.out.println("Banker hand is: ");
            for (Card card : bankerHand) {
                System.out.println(card);
            }
        
            System.out.println("You bet on: "+(bet.equals("player") ? "Player" : "Banker"));

            input.close();
    }
}

