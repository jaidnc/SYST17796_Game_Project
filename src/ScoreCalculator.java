public class ScoreCalculator {
    // Calculate score for a hand of cards
    public static int calculateScore(Card[] hand) {
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total % 10; // Drop left digit if double digits
    }

    // Calculate score for a hand with an additional card
    public static int calculateScore(Card[] hand, Card thirdCard) {
        int total = calculateScore(hand) + thirdCard.getValue();
        return total % 10; // Drop left digit if double digits
    }
}
