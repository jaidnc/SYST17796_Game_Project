public class Card {
    private int value;  // Card value (1 - 9, or 0 for 10, J, Q, K)
    // Constructor
    public Card(int value) {
        if (value >= 10){
            this.value = 0;
        }else{
            this.value = value;
        }
    }

    // Getter method
    public int getValue() {
        return value;
    }


    // Override the toString() method to print the card information
    @Override
    public String toString() {
        return value == 0 ? "Face Card" : String.valueOf(value);
    }
}