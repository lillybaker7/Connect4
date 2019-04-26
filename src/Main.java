import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board newGame = new Board();
        newGame.playGame();
        int playAgain = 1;
        while (playAgain != 0) {
            System.out.println("Would you like to play again? Enter 1 for yes, 0 for no.");
            Scanner scan = new Scanner(System.in);
            playAgain = scan.nextInt();
            if (playAgain == 1) {
                Board oneMore = new Board();
                oneMore.playGame();
            } else if (playAgain == 0) {
                break;
            } else {
                System.out.println("I'm not sure if you'd like to keep playing. Enter a 1 for yes, 0 for no.");
            }
        }
    }
}
