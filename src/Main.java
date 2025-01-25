import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String playerName = scanner.next();

        System.out.print(playerName + ", how many rounds do you want to play? : ");
        int roundCount = scanner.nextInt();

        Player player = new Player(playerName);
        Game game = new Game();
        game.setRoundCount(roundCount);

        for (int i = 1; i <= roundCount; i++) {
            System.out.println("Round " + i + ":");
            game.decider(player.play(scanner));
            game.showScoreBoard();
        }

        scanner.close();
    }
}
