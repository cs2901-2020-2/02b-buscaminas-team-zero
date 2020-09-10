// import java.util.ArrayList;
// import java.util.List;
// import java.util.logging.Logger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Minesweeper {

    // static final Logger logger = Logger.getLogger(Minesweeper.class.getName());

    public  static int[][] generateBoard(int n){
        int board[][] = new int[n][n];

        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                board[row][column] = 0;
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
                if (randomNum == 5){
                    board[row][column] = 1;
                }
            }
        }
        return board;
    }

    public  static void printBoard(int[][] board, int n){
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                    if (board[row][column] != -1){
                        System.out.print("O");
                    }
                    else {
                        System.out.print("X");
                    }
                    System.out.print("\t");
                }
            System.out.print("\n");
        }
    }

    public  static Boolean checkMove(int[][] board, int x, int y){
        if (board[x][y] == 1){
            System.out.println("Game Over");
            return true;
        }
        else {
            return false;
        }
    }

    public  static int inputNum(){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        // input.close();
        return number;
    }


    public static void main(String[] args){
        // logger.info("CS-UTEC Software Engineering I");
        System.out.print("Tamaño del tablero: ");
        int n = inputNum();
        System.out.print("\n");
        int board[][] = generateBoard(n);
        Boolean gameOver = false;

        while (!gameOver){
            printBoard(board, n);
            System.out.print("Ingrese coordenada x: ");
            int x = inputNum();
            System.out.print("\nIngrese coordenada y: ");
            int y = inputNum();
            System.out.print("\n");
            gameOver = checkMove(board, x, y);
            if (!gameOver){
                board[x][y] = -1;
            }
        }


    }

}
