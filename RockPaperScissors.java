/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adarsh K
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RockPaperScissors {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int highestScore = readHighestScore();
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("The highest score so far is " + highestScore);
        String playerName = getPlayerName(scanner);
        int playerScore = 0;
        int computerScore = 0;
        boolean continuePlaying = true;
        
        while (continuePlaying) {
            System.out.println("Make your move (rock, paper, or scissors): ");
            String playerMove = scanner.nextLine();
            String computerMove = getComputerMove();
            System.out.println("Computer chose " + computerMove);
            int result = determineWinner(playerMove, computerMove);
            
            if (result == 1) {
                System.out.println("You win!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins!");
                computerScore++;
            } else {
                System.out.println("It's a draw!");
            }
            
            System.out.println("Current score: " + playerName + " " + playerScore + " - " + "Computer " + computerScore);
            
            if (playerScore > highestScore) {
                System.out.println("Congratulations, you have beaten the highest score!");
                highestScore = playerScore;
                writeHighestScore(highestScore);
            }
            
            System.out.println("Do you want to play again? (y/n)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                continuePlaying = false;
            }
        }
        
        System.out.println("Thanks for playing Rock Paper Scissors!");
    }
    
    public static String getPlayerName(Scanner scanner) {
        System.out.println("Please enter your name: ");
        return scanner.nextLine();
    }
    
    public static String getComputerMove() {
        String[] moves = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * moves.length);
        return moves[randomIndex];
    }
    
    public static int determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return 0;
        } else if (playerMove.equals("rock") && computerMove.equals("scissors")) {
            return 1;
        } else if (playerMove.equals("scissors") && computerMove.equals("paper")) {
            return 1;
        } else if (playerMove.equals("paper") && computerMove.equals("rock")) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static int readHighestScore() {
        try {
            File file = new File("highest_score.txt");
            Scanner scanner = new Scanner(file);
            return scanner.nextInt();
        } catch (IOException e) {
            return 0;
        }
    }
    
    public static void writeHighestScore(int score) {
        try {
            FileWriter writer = new FileWriter("highest_score.txt");
            writer.write(Integer.toString(score));
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }
}
