import java.util.*;
public class Main {
    public static void main(String[] args) {
        PlayerQueue matchMakingQueue = new PlayerQueue(10);
        int t = 0;
        Random rand = new Random();
        int gameCount = 0;
        int playerID = 1;
        //int round = 1 [was for testing]

        while (gameCount < 10) {
            int newPlayers = rand.nextInt(7) + 1;
            System.out.println("Added " + newPlayers + " new players to the MatchMaking queue...");

            for (int i = 0; i < newPlayers; i++) {
                matchMakingQueue.enqueue(new Player(rand.nextInt(50) + 1, "Player" + playerID, playerID));
                playerID++;
            }

            System.out.println("Current queue size: " + matchMakingQueue.getSize());

            if (matchMakingQueue.getSize() >= 5) {
            System.out.println("Starting game with Players: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(matchMakingQueue.dequeue() + " ");
                }
                gameCount++;
                System.out.println("\nGame " + gameCount + " started!\n");
                System.out.println("New queue size: " + matchMakingQueue.getSize());
            }

            System.out.println("Press Anything to continue...");
            System.out.println("-----------------------------");

        }

        System.out.println("PROJECT SUCCESSFUL" + " [GAMES DONE:" + gameCount + "]" );

    }

}
