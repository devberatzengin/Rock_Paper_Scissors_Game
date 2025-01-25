import java.util.Scanner;

public class Player {
    private String name;
    private int computerChoose;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "null";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] play(Scanner scanner) {
        System.out.println("Player " + name + " is playing.");

        int choose = -1;
        while (choose < 0 || choose > 2) {
            System.out.print("Rock[0] Paper[1] Scissors[2] ? : ");
            if (scanner.hasNextInt()) {
                choose = scanner.nextInt();
                if (choose < 0 || choose > 2) {
                    System.out.println("Invalid choice! Please enter 0, 1, or 2.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }

        computerChoose = (int) (Math.random() * 3);

        int[] chooses = {computerChoose, choose};
        return chooses;
    }
}
