import java.util.*;



public class CardLogic {

    private static final int DECK_SIZE = 30;
    private CardStack playerDeck;
    private CardStack playerHand;
    private Random random;
    private Scanner scanner;

    public CardLogic() {
        playerDeck = new CardStack(DECK_SIZE);
        playerHand = new CardStack(DECK_SIZE);
        random = new Random();
        scanner = new Scanner(System.in);
        initializeDeck();
    }

    private String[] exodiaCards = {
            "Head of Exodia", "Arm of Exodia", "ChestPlate of Exodia", "PP of Exodia", "Cortex of Exodia"
    };

    public boolean hasCompleteExodia() {
        boolean[] exodiaFound = new boolean[exodiaCards.length];

        for (int i = 0; i < playerHand.size(); i++) {
            Card card = playerHand.getCardAt(i);
            for (int j = 0; j < exodiaCards.length; j++) { //Checks the specific index of exodiaCards then returns true for that particular card index
                if (card.getName().equals(exodiaCards[j])) {
                    exodiaFound[j] = true;
                }
            }
        }

        // Check if all Exodia pieces are found
        for (boolean found : exodiaFound) { // loop for checking if all index is now set true if not return false
            if (!found) {
                return false;
            }
        }
        return true;
    }

    private String[] cardNames = {
        "NanoMachine Armor", "Ice Gust", "Excalibur's Demise", "Kraken Overload", "Tears of a Maiden",
        "Element Zero", "Struggle", "ChestPlate of Exodia", "Arm of Exodia", "Head of Exodia" ,
        "PP of Exodia", "Pot of Greed", "Cortex of Exodia"
};

    private void initializeDeck() {
        for (int i = 0; i < DECK_SIZE; i++) {
            // picks a name from the array
            String cardName = cardNames[random.nextInt(cardNames.length)];
            playerDeck.push(new Card(cardName));
        }
    }

    public void playGame() {
        System.out.println("Welcome to Balatro -2.0 !");

        while (!playerDeck.isEmpty()) {
            System.out.println("\n--- New Turn ---");
            executeRandomCommand();
            displayGameState();

            if (hasCompleteExodia()) {
                System.out.println("You have drawn all the pieces of Exodia! YOU WIN!");
                return; // Secret Game End
            }

            System.out.println("Press Enter to proceed...");
            scanner.nextLine(); //Just so turns are dictated by the player (windows.h)
        }

        System.out.println("Game Over! YOU WIN!");
        System.out.println("Your Deck Is Empty");
    }

    private void executeRandomCommand() {
        int command = random.nextInt(2); // between 0 & 1
        int x = random.nextInt(5) + 1; // random amount drawn/discarded

        switch (command) {
            case 0:
                System.out.println("Turn Command: Draw " + x + " card(s).");
                drawCards(x);
                break;
            case 1:
                System.out.println("Turn Command: Discard " + x + " card(s).");
                discardCards(x);
                break;
        }
    }

    private void drawCards(int count) {
        for (int i = 0; i < count && !playerDeck.isEmpty(); i++) {
            playerHand.push(playerDeck.pop());
        }
    }

    private void discardCards(int count) {
        for (int i = 0; i < count && !playerHand.isEmpty(); i++) {
            playerHand.pop();

        }
    }

    public void displayGameState() {
        System.out.println("\nYour Hand:");
        if (playerHand.isEmpty()) {
            System.out.println("Your Hand is empty.");
        } else {
            playerHand.printStack();
        }

        System.out.println("Cards left in Deck: " + playerDeck.size());
    }
}
