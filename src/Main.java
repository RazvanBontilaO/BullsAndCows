import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main() {
        Random randomCode = new Random();
        int randomNumber = randomCode.nextInt(9000) + 1000;
        int turn = 1;
        int bull = 0;
        int cow = 0;
        String secretCode = Integer.toString(randomNumber);
        String guessedCode;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman game!");
        System.out.println("The secret code is prepared: ****");

        while (!quit){
            System.out.println("Turn " + turn + ". Answer: ");
            guessedCode = scanner.nextLine();
            if (guessedCode.length() != 4){
                System.out.println("Please enter 4 digits.");
            }else {
                String[] guessedCodes = guessedCode.split("");
                for (int i = 0; i < secretCode.length(); i++) {
                    if (guessedCode.charAt(i) == secretCode.charAt(i)) {
                        bull++;
                        cow--;
                    }
                    if (secretCode.contains(guessedCodes[i])) {
                        cow++;
                    }
                }
                System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s)");
                if (bull != 4) {
                    bull = 0;
                    cow = 0;
                }

                if (bull == 4) {
                    System.out.println("Congrats! The secret code is " + secretCode);
                    quit = true;
                }
            }
            turn++;
        }
    }
}
