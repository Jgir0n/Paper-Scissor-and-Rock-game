package Hw6;

import java.util.Scanner;
import java.util.Random;

public class NewPSRgame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int user_score = 0;
        int comp_score = 0;
        int total_match = 0;  // counts only completed matches (no draws)

        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {
            System.out.println("Select Your Option:");
            System.out.println("1: Paper \n2: Scissors \n3: Rock");

            int user = sc.nextInt();

            if (user < 1 || user > 3) {
                System.out.println("You have chosen the wrong option. Try again.");
                continue;  // skip rest of loop and ask again
            }

            int comp = rand.nextInt(3) + 1; // 1 to 3

            System.out.println("You chose: " + user + ", Computer chose: " + comp);

            if (user == comp) {
                System.out.println("Draw!");
                // total_match not incremented on draw
            } else if (
                (user == 1 && comp == 3) ||
                (user == 2 && comp == 1) ||
                (user == 3 && comp == 2)
            ) {
                System.out.println("You win!");
                user_score++;
                total_match++;
            } else {
                System.out.println("Computer wins!");
                comp_score++;
                total_match++;
            }

            if (total_match > 0) {
                float win_percent_user = ((float) user_score / total_match) * 100;
                float win_percent_comp = ((float) comp_score / total_match) * 100;

                System.out.printf("Your winning percent: %.2f%%\n", win_percent_user);
                System.out.printf("Computer winning percent: %.2f%%\n", win_percent_comp);
            } else {
                System.out.println("No matches completed yet.");
            }

            System.out.println("Do you want to play again? (y/n): ");
            choice = sc.next().charAt(0);
        }

        System.out.println("Game over! Final score - You: " + user_score + " Computer: " + comp_score);
        sc.close();
    }
}
