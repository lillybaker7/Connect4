import java.util.Scanner;
import java.util.Arrays;

public class Board {

    String[][] board;
    int turnNum = 1;

    public Board(){
        this.board = new String[8][8];
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                this.board[i][j] = " ";
    }

    public void playGame(){
        System.out.println(Arrays.deepToString(this.board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace(",", "|"));
        System.out.println("Welcome! Player one is X and Player two is O.");
        //boolean win = false;
        while (checkWinRow()==false && checkWinCol()==false && checkWinDiag()==false){
            int col = pickACol();
            updateBoard(col);
        }
        if (turnNum%2 == 0){
            System.out.println("Congratulations player one! You won!");
        }
        else{
            System.out.println("Congratulations player two! You won!");
        }

//        if (turnNum%2==0){
//            System.out.println("O, you won!");
//        }
//        else{
//            System.out.println("X, you won!");
//        }
    }

    public int pickACol(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick a column 1-8.");
        int col = scan.nextInt();
        while (col > 8 || col < 1){
            System.out.println("Whoops! Please make sure your number is 1-8.");
            col = scan.nextInt();
        }
        return col;
    }

    public void updateBoard(int col){
        String player = "";
        if (turnNum%2==0){
            player = "O";
        }
        else{
            player = "X";
        }
        for (int i = 7; i > -1; i--){
            if (this.board[i][col-1].equals(" ")) {
                this.board[i][col-1] = player;
                break;
            }
        }
        System.out.println(Arrays.deepToString(this.board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace(",", "|"));
        turnNum++;
    }

    public boolean checkWinRow(){
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (!this.board[i][j].equals(" ") && this.board[i][j].equals(this.board[i][j+1]) && this.board[i][j+1].equals(this.board[i][j+2]) && this.board[i][j+2].equals(this.board[i][j+3])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinCol(){
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (!this.board[i][j].equals(" ") && this.board[i][j].equals(this.board[i+1][j]) && this.board[i+1][j].equals(this.board[i+2][j]) && this.board[i+2][j].equals(this.board[i+3][j])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinDiag() {
        for (int i = 7; i >= 3; i--) {
            for (int j = 7; j >= 3; j--) {
                if (!this.board[i][j].equals(" ") && this.board[i][j].equals(this.board[i - 1][j - 1]) && this.board[i - 1][j - 1].equals(this.board[i - 2][j - 2]) && this.board[i - 2][j - 2].equals(this.board[i - 3][j - 3])) {
                    return true;
                }
            }
        }
        for (int i = 7; i >= 3; i--) {
            for (int j = 0; j < 5; j++) {
                if (!this.board[i][j].equals(" ") && this.board[i][j].equals(this.board[i - 1][j + 1]) && this.board[i - 1][j + 1].equals(this.board[i - 2][j + 2]) && this.board[i - 2][j + 2].equals(this.board[i - 3][j + 3])) {
                    return true;
                }

            }
        }
        return false;
    }


//    public boolean checkWin(){
//        if (checkWinCol() || checkWinRow()){
//            return true;
//        }
//        return false;
//    }
}
