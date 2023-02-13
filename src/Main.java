import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ',' ',' '},
                          {' ',' ',' '},
                          {' ',' ',' '}
        };
        printBoard(board);

        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }

    private static boolean hasContesttanWon(char[][] board, char symbol){
        if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) ) {
            return true;
        }
        else return false;
    }

    private static boolean isGameFinished(char[][] board){
        if (hasContesttanWon(board,'X')){
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        }

        if (hasContesttanWon(board,'O')){
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        System.out.println("The Game is finished");
        return true;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while(true){
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board,computerMove)){
                break;
            }
        }
        System.out.println("Computer choose: " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static void playerTurn(char[][] board ,Scanner scanner){
        String userInput;
        while(true){
            System.out.println("Which one do u wanna play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board,Integer.parseInt(userInput))){
                break;
            }
            else {
                System.out.println(userInput + "is valid");
            }
        }
        placeMove(board,userInput,'X');
    }




    private static boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1 -> {
                return (board[0][0] == ' ');
            }
            case 2 -> {
                return (board[0][1] == ' ');
            }
            case 3 -> {
                return (board[0][2] == ' ');
            }
            case 4 -> {
                return (board[1][0] == ' ');
            }
            case 5 -> {
                return (board[1][1] == ' ');
            }
            case 6 -> {
                return (board[1][2] == ' ');
            }
            case 7 -> {
                return (board[2][0] == ' ');
            }
            case 8 -> {
                return (board[2][1] == ' ');
            }
            case 9 -> {
                return (board[2][2] == ' ');
            }
            default -> {
                return false;
            }
        }
    }

    private static void placeMove(char[][] board, String position, char symbol){

        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default ->
                    System.out.println("1 ile 9 arasinda reqem secin!");

        }
    }

    private static void printBoard(char[][] board){
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }


}
