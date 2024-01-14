import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // player wins
        int playerOneWins = 0;
        int playerTwoWins = 0;

        // greeting
        System.out.println("Hello!");

        // player names
        System.out.println("Please enter player 1's name: ");
        String playerOneName = scanner.nextLine();
        System.out.println("Please enter player 2's name: ");
        String playerTwoName = scanner.nextLine();

        // game
        while (true) {
            String playerOneChoice;
            String playerTwoChoice;

            do {
                System.out.println(playerOneName + ": Enter your choice (rock/paper/scissors): ");
                playerOneChoice = scanner.nextLine().toLowerCase();
                if (!isValidChoice(playerOneChoice)) {
                    System.out.println("Please choose rock, paper, or scissors.");
                }
            } while (!isValidChoice(playerOneChoice));

            do {
                System.out.println(playerTwoName + ": Enter your choice (rock/paper/scissors): ");
                playerTwoChoice = scanner.nextLine().toLowerCase();
                if (!isValidChoice(playerTwoChoice)) {
                    System.out.println("Please choose rock, paper, or scissors.");
                }
            } while (!isValidChoice(playerTwoChoice));

            // check winner
            String winner = determineWinner(playerOneChoice, playerTwoChoice);
            if (winner.equals(playerOneChoice)) {
                System.out.println(playerOneName + " wins this round!");
                playerOneWins++;
            } else if (winner.equals(playerTwoChoice)) {
                System.out.println(playerTwoName + " wins this round!");
                playerTwoWins++;
            } else {
                System.out.println("It's a tie!");
            }

            // current score
            System.out.println("Current Score:");
            System.out.println(playerOneName + ": " + playerOneWins);
            System.out.println(playerTwoName + ": " + playerTwoWins);

            System.out.println("Do you want to play again? (y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        // final results
        System.out.println("Thanks for playing!");
        System.out.println("The Final Score is:");
        System.out.println(playerOneName + ": " + playerOneWins);
        System.out.println(playerTwoName + ": " + playerTwoWins);
        scanner.close();
    }

    // determine the winner
    public static String determineWinner(String choice1, String choice2) {
        if (choice1.equals(choice2)) {
            return "tie";
        } else if (
            (choice1.equals("rock") && choice2.equals("scissors")) ||
            (choice1.equals("r") && choice2.equals("s")) ||
            (choice1.equals("paper") && choice2.equals("rock")) ||
            (choice1.equals("p") && choice2.equals("r")) ||
            (choice1.equals("scissors") && choice2.equals("paper")) ||
            (choice1.equals("s") && choice2.equals("p"))
        )
        {
            return choice1;
        } else {
            return choice2;
        }
    }

    // validate choice
    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors") || 
        choice.equals("r") || choice.equals("p") || choice.equals("s");
    }
}