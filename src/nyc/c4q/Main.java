package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain == true) {
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            boolean askPlayAgain = true;
            while(askPlayAgain == true) {
                System.out.println("Play again? (y/n)");
                Scanner scannerPlayAgain = new Scanner(System.in);
                char playAgainInput = Character.toLowerCase(scannerPlayAgain.next().charAt(0));
                if (playAgainInput == 'y') {
                    askPlayAgain = false;
                }
                else if (playAgainInput == 'n') {
                    askPlayAgain = false;
                    playAgain = false;
                }
                else{ System.out.println("what was that?");
                }
            }

        }
    }
}
