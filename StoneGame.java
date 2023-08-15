import java.util.Scanner;

public class StoneGame {
    // Function that takes the user's number of stones and checks it against the maximum number of stones picked per round of play
    public static int validateUserChoice(int currentPlayerInput, int maxPick) {
        Scanner keyboard = new Scanner(System.in);
        while ((currentPlayerInput > maxPick) || (currentPlayerInput <= 0)) {
            if (maxPick == 1) {
                System.out.print("You can only choose one stone");
            } else {
                System.out.print("You must pick between 1 and " + maxPick + " stones: ");
            }
            currentPlayerInput = keyboard.nextInt();
        }
        return currentPlayerInput;
    }
    public static int maximumPick(int pick, int totalStones){
        int  maxPick = 2 * pick;
         if (maxPick >= totalStones)
             maxPick = totalStones;
         return maxPick;
     }
    /**Function takes string and integer arguments and computes their names, 
    total of each player's respective stones, total stones and the maximum number of stones picked per round of play**/
    public static void repeatPrompt(String playerTurn, String player1, String player2, int player1TotalStones, int player2TotalStones, int totalStones,int maxPick) {
        System.out.println("\n" + player1 + " (Player 1) has " + player1TotalStones + " stones.");
        System.out.println(player2 + " (Player 2) has " + player2TotalStones + " stones.");
        System.out.println("There are " + totalStones + " stones left in the pile");
    // The conditional statement ensures the correct grammatical sentence is displayed depending on the number of stones left during the game
        if (maxPick == 1) {
            System.out.println(playerTurn + " you can only choose one stone");
        }
        else {
            System.out.print(playerTurn + " choose between 1 and " + maxPick + " stones\n");
        }    
    }
    public static void main(String args[]) {
        int player1TotalStones = 0;                             //Total number of stones player one has picked 
        int player2TotalStones = 0;                             //Total number of stones player two has picked
        int pick = 0;                                           //Total number of stones picked after each round
        Scanner keyboard = new Scanner(System.in);              //Takes input from the user
    // Number of stones users want to start and play with but continuously requests for an acceptable number if rule is violated
        System.out.print("What number of stones do you want to start with? (Please your stones should be positive, odd and greater than 1): ");
        int totalStones = keyboard.nextInt();
        while ((totalStones <= 1) || (totalStones % 2 == 0)) {
            System.out.print("Please enter your number of stones again (Please your stones should be positive, odd and greater than 1): ");
            totalStones = keyboard.nextInt();
        }
    //Ask the two users for their names and ensures first player's stones does not exceed half the total stones    
        System.out.print("Player 1 please enter your name: ");
        String player1 = keyboard.next();

        System.out.print("Player 2 please enter your name: ");
        String player2 = keyboard.next();

        int maxPick = (int) (0.5 * totalStones);
    //Asks each player to enter the number of stones they want to pick and updates players stones picked and total available stones    
    repeatPrompt(player1, player1, player2, player1TotalStones, player2TotalStones, totalStones, maxPick);
                pick = validateUserChoice(keyboard.nextInt(), maxPick);
                totalStones -= pick;                                           
                player1TotalStones += pick;                     
    //Loop continues for remaining stones until no stone is left    
    while (totalStones > 0) {
        maxPick = maximumPick(pick, totalStones);
    repeatPrompt(player2, player1, player2, player1TotalStones, player2TotalStones, totalStones, maxPick);
                pick = validateUserChoice(keyboard.nextInt(), maxPick);
                totalStones -= pick;
                player2TotalStones += pick;
                if (totalStones == 0)
                    break;
        maxPick = maximumPick(pick,totalStones);   
    repeatPrompt(player1, player1, player2, player1TotalStones, player2TotalStones, totalStones, maxPick);
    //Ask player1 with the name to enter the number of stones they want to pick. Input must not be > half of the initial amount of stones
                pick = validateUserChoice(keyboard.nextInt(), maxPick);
                totalStones -= pick;
                player1TotalStones += pick;
        }
                System.out.println(player1 + " (Player 1) has " + player1TotalStones + " stones.");
                System.out.println(player2 + " (Player 2) has " + player2TotalStones + " stones.");
                System.out.println("There are " + totalStones + " stones left in the pile");
                if (player1TotalStones % 2 == 0)
                    System.out.println(player2 + " wins.");
                else
                    System.out.println(player1 + " wins.");
    }
}