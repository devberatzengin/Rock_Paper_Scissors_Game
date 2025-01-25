import java.util.Scanner;

public class Game {

    private int round;
    private int currentRound = 1;
    private int[][] scoreBoard;

    public void setRoundCount(int round) {
        this.round = round;
        scoreBoard = new int[round][2];
        this.getReadyScoreBoard();
    }

    public void getReadyScoreBoard() {
        for (int i = 0; i < round; i++) {
            scoreBoard[i][0] = 0;
            scoreBoard[i][1] = 0;
        }
    }

    public void decider(int[] scores) {
        if (currentRound > round) {
            System.out.println("All rounds are completed!");
            return;
        }

        int computerChoice = scores[0];
        int playerChoice = scores[1];

        System.out.println("Computer chose: " + convertChoice(computerChoice));
        System.out.println("Player chose: " + convertChoice(playerChoice));

        if (computerChoice == playerChoice) {
            System.out.println("----DRAW----");
        } else if ((computerChoice == 0 && playerChoice == 1) ||
                (computerChoice == 1 && playerChoice == 2) ||
                (computerChoice == 2 && playerChoice == 0)) {
            System.out.println("----YOU WON, COMPUTER LOSE----");
            scoreBoard[currentRound - 1][1] = 3;
        } else {
            System.out.println("----YOU LOSE, COMPUTER WON----");
            scoreBoard[currentRound - 1][0] = 3;
        }

        currentRound++;
    }

    public void showScoreBoard() {
        System.out.println("----------------------------------");
        System.out.println("Round: " + (currentRound - 1));
        System.out.println("Computer Score: " + getTotalScore(0));
        System.out.println("Player Score: " + getTotalScore(1));
        System.out.println("----------------------------------");
    }

    private int getTotalScore(int index) {
        int total = 0;
        for (int i = 0; i < currentRound - 1; i++) {
            total += scoreBoard[i][index];
        }
        return total;
    }

    private String convertChoice(int choice) {
        return switch (choice) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            default -> "Unknown";
        };
    }
}
